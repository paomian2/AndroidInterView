package com.linxz.interfaces;

/**
 * @author Linxz
 * 创建日期：2020年08月25日 19:22
 * version：v5.0.0
 * 描述：jdk8新特效，允许方法中实现接口，不过需要使用default修饰
 *
 *      如果继承MP3Play，MP4Play继承，则需要实现play方法
 *
 *      使用场景：订单状态机制，比如页面有多种类型的订单(车险订单、洗车订单等等)，不同的页面展示不一样，按钮不一样，所以使用不同的订单实体类，
 *      adapter实体为接口，直接使用接口获取对应的子段或者按钮
 */
public class Interface_JDK8 {

    public static void main(String[] args) {
        Player player=new Player();
        player.play();
    }


    private static class Player implements MP3Play{


    }

    interface MP3Play{
        default void play(){
            System.out.println("我是MP3");
        }
    }

    interface MP4Play{
        default void play(){
            System.out.println("我是MP4");
        }
    }
}
