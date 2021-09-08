package com.linxz.Lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Linxz
 * 创建日期：2021年09月07日 3:04 下午
 * version：
 * 描述：
 */
public class SelfLockClassSimple {

    private static Lock lock3 = new SelfLock();
    private static Lock lock4 = new SelfLock();

    private static void play1() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while (true){
            if (lock3.tryLock()){
                try {
                    System.out.println("线程"+threadName+":获得lock3锁");
                    if (lock4.tryLock()){
                        try {
                            System.out.println("线程"+threadName+":获得lock4锁");
                            break;
                        }finally {
                            lock4.unlock();
                        }
                    }
                }finally {
                    lock3.unlock();
                }
            }
            Thread.sleep(new Random().nextInt(3));//解决(活锁，一直在拿锁、释放锁，直到符合条件)
        }
    }

    private static void play2() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while (true){
            if (lock4.tryLock()){
                try {
                    System.out.println("线程"+threadName+":获得lock4锁");
                    if (lock3.tryLock()){
                        try {
                            System.out.println("线程"+threadName+":获得lock3锁");
                            break;
                        }finally {
                            lock3.unlock();
                        }
                    }
                }finally {
                    lock4.unlock();
                }
            }
            Thread.sleep(new Random().nextInt(3));//解决(活锁，一直在拿锁、释放锁，直到符合条件)
        }
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    play1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    play2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    public static class SelfLock implements Lock{
        //真正同步类的实现都依赖继承于AQS的自定义同步器！
        private final Sync sync = new Sync();

        @Override
        public void lock() {
            sync.acquire(1);
        }


        //tryLock<-->tryAcquire。两者语义一样：尝试获取资源，要求立即返回。成功则为true，失败则为false。
        @Override
        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        @Override
        public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
            return false;
        }

        @Override
        public void unlock() {
            sync.tryRelease(1);
        }

        @Override
        public Condition newCondition() {
            return sync.newCondition();
        }
        @Override
        public void lockInterruptibly() throws InterruptedException {}
        //锁是否占有状态
        public boolean isLocked() {
            return sync.isHeldExclusively();
        }

        private static class Sync extends AbstractQueuedSynchronizer{
            //判断是否处于占用状态
            @Override
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }
            //获得锁
            @Override
            protected boolean tryAcquire(int arg) {
                ////state为0才设置为1，不可重入！
                if (compareAndSetState(0,1)){
                    //设置为当前线程独占资源
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            //释放锁
            @Override
            protected boolean tryRelease(int arg) {
               if (getState() == 1) throw new IllegalMonitorStateException();////既然来释放，那肯定就是已占有状态了。只是为了保险，多层判断！
               setExclusiveOwnerThread(null);
               setState(0);////释放资源，放弃占有状态
               return true;
            }

            Condition newCondition(){ return new ConditionObject(); }
        }
    }
} 