package com.linxz.Lock;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author Linxz
 * 创建日期：2021年09月08日 11:11 上午
 * version：
 * 描述：Unsafe可以获取并修改Java堆中的数据
 * 参考：https://www.jianshu.com/p/9819eb48716a
 *     https://www.cnblogs.com/linghu-java/p/9686651.html
 */
public class CAS_UnSafe_ClassSimple {


   // private static final Unsafe U = Unsafe.getUnsafe();
    //只有主加载器才能只有由主类加载器加载的类才能调用getUnsafe这个方法
    //使用反射得到Unsafe
   private static final Unsafe U = getUnsafeInstance();
   @SuppressWarnings("DiscouragedPrivateApi")
   static sun.misc.Unsafe getUnsafeInstance() {
       Field field;
       try {
           field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
           field.setAccessible(true);
           return (Unsafe) field.get(null);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }


   private static class Test{
       public int intfield ;
       private Test(){
           System.out.println("constructor called");
       }
   }

    public static void main(String[] args) throws Exception {
       //见Java基础文件
        Test test = (Test) U.allocateInstance(Test.class);
        test.intfield = 100;
        System.out.println("Test地址-"+test+" ---intfield:"+test.intfield);
        //获取属性intfield地址偏移量
        long b1 = U.objectFieldOffset(Test.class.getDeclaredField("intfield"));
        U.putInt(test,b1,10000);
        System.out.println("Test地址-"+test+" ---修改后intfield:"+test.intfield);
        //如果偏移量(b1)对应的值跟expected一样，偏移量(b1)的值修改为x的值，并且返回true。否则不作处理并且返回false
        boolean b= U.compareAndSwapInt(test, b1, 10000, 1);
        System.out.println("compareAndSwapInt："+b);
        System.out.println("Test地址-"+test+" ---compareAndSwapInt:"+test.intfield);
    }
}