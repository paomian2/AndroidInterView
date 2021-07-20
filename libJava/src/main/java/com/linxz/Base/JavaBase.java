package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2021年01月12日 22:45
 * version：
 * 描述：
 */
public class JavaBase {


    static class User2{
        public String name;

        @Override
        public boolean equals(Object o) {
            return true;
        }
    }

    public User2 init(User2 user){
        if (user==null){
            user=new User2();
            user.name="张飞";
        }
        return user;
    }


    public static void main(String[] args) {
//        User2 user2=null;
//        JavaBase javaBase=new JavaBase();
//        user2=javaBase.init(user2);
//        System.out.println("user2:"+user2);

//        User2 user1=null;
//        User2 user2=user1;
//        user1=new User2();
//        System.out.println(user1);
//        System.out.println(user2);
//
//
//        int i=9>>>1;
//        int j=9>>1;
//        System.out.println(i);
//        System.out.println(j);


//        User2 user1=new User2();
//        user1.name="张三";
//        User2 user2=new User2();
//        user2.name="李四";

      //  System.out.println(isNaN(0.1F));


        Float f1=0.1F/0.0F;
        System.out.println(f1);
        test(f1);
    }

    public static void test(float f){
        System.out.println("dfsafasdf");
        System.out.println(f*0);
        System.out.println(Float.isNaN(f));
        System.out.println(Float.isNaN(Float.valueOf("0.1")));
        System.out.println(Float.isNaN(0.1F));
        System.out.println(Float.isNaN(0.0F/0.0F));
        System.out.println(0.0F/0.0F);
    }


    public static boolean isNaN(float value){
        return value!=value;
    }
}
