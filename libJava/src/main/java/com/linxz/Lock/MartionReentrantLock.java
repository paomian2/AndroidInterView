package com.linxz.Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Linxz
 * 创建日期：2021年09月07日 5:32 下午
 * version：
 * 描述：
 */
public class MartionReentrantLock implements Lock {


    //标记重入次数的count值
    AtomicInteger count = new AtomicInteger(0);

    //锁的拥有者
    AtomicReference<Thread> owner = new AtomicReference<>();

    //等待队列
    private LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();


    @Override
    public boolean tryLock() {
        //判断count是否为0，若count！=0，说明锁被占用
        int ct = count.get();
        if (ct !=0 ){
            //判断锁是否被当前线程占用，若被当前线程占用，做重入操作，count+=1
            if (owner.get() == Thread.currentThread()){
                count.set(ct + 1);
                return true;
            }else{
                //若不是当前线程占用，互斥，抢锁失败，return false
                return false;
            }
        }else{
            //若count=0， 说明锁未被占用，通过CAS（0，1） 来抢锁
            if (count.compareAndSet(ct, ct +1)){
                //若抢锁成功，设置owner为当前线程的引用
                owner.set(Thread.currentThread());
                return true;
            }else{
                //CAS操作失败，说明情锁失败 返回false
                return false;
            }
        }
    }

    @Override
    public void lock() {
        //尝试抢锁
        if (!tryLock()){
            //如果失败，进入等待队列
            waiters.offer(Thread.currentThread());

            //自旋
            for (;;){
                //判断是否是队列头部，如果是
                Thread head = waiters.peek();
                if (head == Thread.currentThread()){
                    //再次尝试抢锁
                    if (!tryLock()){
                        //若抢锁失败，挂起线程，继续等待
                        LockSupport.park();
                    }else{
                        //若成功，就出队列
                        waiters.poll();
                        return;
                    }
                }else{
                    //如果不是，就挂起线程
                    LockSupport.park();
                }
            }
        }
    }

    @Override
    public void unlock() {
        if (tryUnlock()){
            Thread th = waiters.peek();
            if (th !=null){
                LockSupport.unpark(th);
            }
        }
    }


    public boolean tryUnlock(){
        //判断，是否是当前线程占有锁，若不是，抛异常
        if (owner.get() != Thread.currentThread()){
            throw new IllegalMonitorStateException();
        }else{
            //如果是，就将count-1  若count变为0 ，则解锁成功
            int ct = count.get();
            int nextc = ct-1;
            count.set(nextc);

            //判断count值是否为0
            if (nextc == 0){
                owner.compareAndSet(Thread.currentThread(), null);
                return true;
            }else{
                return false;
            }
        }
    }



    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }




    //商品数量
    private  int stockCount=5;
    //自定义锁
    public static void main(String[] args) {
        MartionReentrantLock lockTest = new MartionReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            executorService.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            lockTest.descStock(lockTest);
                        }
                    }
            );
        }


        executorService.shutdown();

    }


    //模拟数据库减库存
    void descStock(MartionReentrantLock reentrantLock){
        //Runtime
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.getName();
        reentrantLock.lock();
        if(stockCount>0){
            //模拟数据库延时，方便看到效果
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stockCount--;
            System.out.println(threadName+"下单成功，商品剩余" + stockCount);
        }else{
            System.out.println(threadName+"下单失败，已经没有商品剩余" );
        }
        reentrantLock.unlock();

    }
}

