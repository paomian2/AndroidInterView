package com.linxz.Lock;

/**
 * @author Linxz
 * 创建日期：2021年09月06日 6:27 下午
 * version：
 * 描述：
 */
public class 错误加锁 {
//> Task :libJava:错误加锁.main() 目标：输出2，3，4，5，6
//Thread-3-----4-@1178303746
//Thread-1-----4-@102586067
//Thread-0-----4-@1178303746
//Thread-2-----4-@1178303746
//Thread-4-----5-@102586067
//执行阶段执行完毕
//hasCode已经被改变了，也就是i对象不是同一个(i++对象已经改变)，所有加锁没效果
//拆装箱过程(反编译.class文件查看) Integer.valueOf(i)+1,Integer.valueOf()重新new一个Integer
//所有锁的不是同一个对象
//改：new Object，锁object
    public static void main(String[] args) {
        Worker worker = new Worker(0);
        for (int i=0;i<5;i++){
            new Thread(worker).start();
        }
    }

    private static class Worker implements Runnable{
        private Integer i;

        public Worker(Integer i){
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (i){
                Thread thread = Thread.currentThread();
                i++;
                System.out.println(thread.getName()+"-----"+i+"-@"+System.identityHashCode(i));
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
} 