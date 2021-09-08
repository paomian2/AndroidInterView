package com.linxz.Lock;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

import sun.misc.Unsafe;


/**
 * @author Linxz
 * 创建日期：2021年09月08日 2:06 下午
 * version：
 * 描述：
 * 将state进行CAS操作
 */
public class MyReentrantLock3 {

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
        //释放锁操作,进行CAS操作，该方法可以修改state
        if (compareAndSwapState(state,0)){
            stateThread = null;
            Thread headThread = threadQueue.peek();
            LockSupport.unpark(headThread);
        }
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
        //将state进行CAS操作，该操作可以同时修改state状态,如果state==0，则修改为1
        if (compareAndSwapState(0,1)){
            stateThread = currentThread;
            return true;
        }
        return false;
    }

    //获取state地址中state的值跟expected进行比较，如果相等，则把updateValue设置进去，并且返回true。否则sate不变，并且返回false
    private boolean compareAndSwapState(int expected,int updateValue){
        return U.compareAndSwapInt(this,stateOffSet,expected,updateValue);
    }

    private final static Unsafe U = getUnsafeInstance();
    private final static long stateOffSet;

    @SuppressWarnings("DiscouragedPrivateApi")
    static sun.misc.Unsafe getUnsafeInstance() {
        Field field;
        try {
            field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (sun.misc.Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static {
        try {
            stateOffSet = U.objectFieldOffset(MyReentrantLock3.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
           throw new Error(e);
        }
    }



    public static void main(String[] args) {
        MyReentrantLock3 lockTest = new MyReentrantLock3();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
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
    private  int stockCount=50;
    //购物
    private void buyGoods(MyReentrantLock3 reentrantLock){
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