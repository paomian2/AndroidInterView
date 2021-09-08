package com.linxz.Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Linxz
 * 创建日期：2021年09月08日 9:46 上午
 * version：
 * 描述：这个锁没有进行CAS，也是不安全的
 * state属性需要进行CAS才能真正安全
 */
public class MyReentrantLock2 {

    //资源是否被占用  0.没有被占用  1.被占用
    private volatile int state;
    //占用资源的线程
    private Thread stateThread;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private LinkedBlockingQueue<Thread> threadQueue = new LinkedBlockingQueue<>();

    //1.尝试获得锁。获得锁则return做业务
    //没有获得锁：1.将线程打包放入队列
    //          2.当前线程进入死循环，防止当前线程执行完成
    //          3.死循环特别占用CPU，将当前线程进行阻塞
    //          4.如果当前线程被唤醒，判断当前线程是否在队列的队头，再次尝试或得锁，如果获得return回去做业务，否则在此进行阻塞
    public void lock() {
        if (tryAcquire()) return;
        Thread currentThread = Thread.currentThread();
        threadQueue.add(currentThread);
        for (; ; ) {
            if (threadQueue.size() > 0 && currentThread == threadQueue.peek() && tryAcquire()){
                threadQueue.poll();
                return;
            }
            LockSupport.park(currentThread);
        }
    }

    //释放锁 只有资源被占用的时候才正面资源被锁住(即state不等于0)
    // 1.操作释放锁操作的线程是否跟当前占用资源的线程是同一个(其他线程不能让我释放锁)
    // 2.释放资源的时候也要将占用资源的线程移除
    // 3.唤醒队列中队头线程
    public void unLock(){
        int state = getState();
        if (state == 0) return;
        Thread currentThread = Thread.currentThread();
        if (currentThread != stateThread) return;
        //释放锁操作
        setState(0);
        stateThread = null;
        Thread headThread = threadQueue.peek();
        LockSupport.unpark(headThread);
    }

    //true表示获得锁，获得锁的时候表示可以占用资源，所有state设置为1
    private boolean tryAcquire() {
        int state = getState();
        if (state != 0)
            return false;
        Thread currentThread = Thread.currentThread();
        //公平锁，可以出队的线程才可以获得锁
        if (threadQueue.size() > 0 && currentThread != threadQueue.peek())
            return false;
        stateThread = currentThread;
        setState(1);
        return true;
    }

    public static void main(String[] args) {
        MyReentrantLock2 lockTest = new MyReentrantLock2();
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for(int i=0;i<1000;i++){
            executorService.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            lockTest.buyGoods(lockTest);
                        }
                    }
            );
        }
        executorService.shutdown();
    }

    //商品数量
    private  int stockCount=500;
    //购物
    private void buyGoods(MyReentrantLock2 reentrantLock){
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.getName();
        reentrantLock.lock();
        if(stockCount>0){
            try {
                //mock延时业务操作
                Thread.sleep(200);
                stockCount--;
                System.out.println(threadName+"下单成功，商品剩余" + stockCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(threadName+"下单失败，出现异常"+e.getMessage() );
            }
        }else{
            System.out.println(threadName+"下单失败，已经没有商品剩余" );
        }
        reentrantLock.unLock();
    }
}