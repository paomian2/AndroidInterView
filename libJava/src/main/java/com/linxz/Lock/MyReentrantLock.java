package com.linxz.Lock;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

import sun.misc.Unsafe;

/**
 * @author Linxz
 * 创建日期：2021年09月07日 5:08 下午
 * version：
 * 描述：有问题
 *
 */
public class MyReentrantLock {
    //锁状态，默认为0，表示无锁。获取锁则加1，释放锁则建1。
    private volatile int state;
    //持有锁的线程
    private Thread lockHolder;
    //创建一个线程安全的同步队列，存放等待获取锁的线程
    private ConcurrentLinkedQueue<Thread> queue = new ConcurrentLinkedQueue();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public boolean tryAcquire() {
        Thread thread = Thread.currentThread();
        int state = getState();
        if (state == 0) {
            //如果是公平锁，获取锁的时候需要判断当前线程是否是同步队列中第一个排队的，非公平锁不用判断队列
            //compareAndSwapState(0,1)：判断state地址偏移量的值(其实就是值)是不是跟0一致，如果是则修改为1，并且返回true。否则不处理并且返回false
            if ((queue.size() == 0 || thread == queue.peek()) && compareAndSwapState(0, 1)) {
                setLockHolder(thread);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取锁，三种场景
     * 1，使用CAS直接获取锁
     * 2，如果没有获取锁则停留在当前方法
     * 3，其他线程将锁释放后，该线程尝试再次获取锁
     */
    public void lock() {
        //使用CAS获取锁，得到锁，return进行正常的业务操作，
        // 否则1.加入队列
        //    2.进入死循环防止当前线程执行完成(死循环占用CPU,使用LockSupport.park阻塞线程)
        //    3.线程被唤醒后检查自己是否在可以出队列，并且再次尝试获得锁，获得锁return返回，没有继续使用LockSupport.park阻塞线程)
        if (tryAcquire()) {
            return;
        }
        // 没有获取到锁的线程，将其引用放到队列中
        Thread currentThread = Thread.currentThread();
        queue.add(currentThread);

        //阻塞等待，死循环会特别占用CPU，因此使用LockSupport.park阻塞线程。阻塞的线程需要唤醒后才能继续执行
        for (; ; ) {
            //如果线程被唤醒，继续尝试获取锁
            if ((queue.size() == 0 || currentThread == queue.peek()) && tryAcquire()) {
                //System.out.println(currentThread.getName()+"获取到了锁");
                //同步队列中获取到锁线程，需要从同步队列中取出
                queue.poll();
                return;
            }
            //阻塞线程，如果没有获取锁则停留在当前方法
            LockSupport.park(currentThread);
        }
    }

    //释放锁
    public void unlock() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != getLockHolder()) {
            throw new RuntimeException("不是持有锁的线程，不能释放");
        }

        //释放锁，将锁状态置为0
        int state = getState();
        //compareAndSwapState判断state地址偏移量对应的的值(其实就是值)是否跟getState()一致，一致则修改为0并且返回true，否则不处理并且返回false
        if (compareAndSwapState(state, 0)) {
            // System.out.println(currentThread.getName()+"释放了锁");
            //当前获取锁的线程置null，没有线程获取到锁
            setLockHolder(null);
            //从队列中获得第一个等待的线程，并将其唤醒
            Thread thread = queue.peek();
            LockSupport.unpark(thread);
        }
    }

    /**
     * 使用CAS设置锁状态，该操作是原子操作
     *
     * @param oldValue
     * @param newValue
     * @return
     */
    private boolean compareAndSwapState(int oldValue, int newValue) {
        return unsafe.compareAndSwapInt(this, stateOffset, oldValue, newValue);
    }

    /**
     * 使用反射获取Unsafe实例，无法直接获取，否则会报安全异常
     *
     * @return
     */
    static Unsafe getUnsafeInstance() {
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static final Unsafe unsafe = getUnsafeInstance();
    private static final long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(MyReentrantLock.class.getDeclaredField("state"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    //商品数量
    private  int stockCount=5;
    //自定义锁
    public static void main(String[] args) {
        MyReentrantLock lockTest = new MyReentrantLock();
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

    private SelfLockClassSimple.SelfLock selfLock = new SelfLockClassSimple.SelfLock();
    //模拟数据库减库存
    void descStock(MyReentrantLock reentrantLock){
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