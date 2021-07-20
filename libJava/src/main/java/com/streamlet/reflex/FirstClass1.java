package com.streamlet.reflex;

/**
 * @author Linxz
 * 创建日期：2021年03月03日 12:48 AM
 * version：
 * 描述：反射
 *
 * 万事万物皆对象
 * 我们写的class也是一个对象
 *
 * Java底层有的类   class类
 *               /    ｜
 *            Filed类 Constructor类   Method类
 *
 * class类记录我们自己编写的类对应的信息，修饰符，方法，注解，实现的接口等。
 *
 * 我们自己定义的类的对象可以new无数个，但是jvm中对应class类只能有一个(也就是说FirstClass1是class的一个对象，但这个对象只能有一个)。
 *
 * 我们new FirstClass1对象的时候，会先去虚拟机看看这个FirstClass1有没有被加载过，如果没有加载过，先将FirstClass1对应的class对象进行加载，有了这个对象之后才
 * 才能将FirstClass1的对象new出来
 *
 * class对象唯一性标志：类加载器+class对象
 * 怎么获取虚拟机中FirstClass1对应的class对象(联想：class FirstClass1=new class())？
 * 1.Class mFirstClz=FirstClass1.class;
 * 2.FirstClass1 mFirst=new FirstClass1();
 *   Class mFirstClz=mFirst.getClass();
 * 3.Class mFirstClz=Class.forName(包名+类名);
 * (前面两种需要明确知道FirstClass1存在)
 *
 * 拿到这个Class对象之后能做哪些事情？
 * 1.newInstance()得到FirstClass1对象
 * 2.知道这类实现的接口、方法、注解、读取/修改属性
 */
class FirstClass1 {



    private String color;
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }


    public static void main(String[] args) {
        try {
            Class shapeClz=Class.forName("com.streamlet.reflex.FirstClass1");
            FirstClass1 shape= (FirstClass1) shapeClz.newInstance();
            shape.setColor("红色");
            System.out.println(shape.getColor());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
