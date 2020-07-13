package com.linxz.interfaces;

/**
 * @author Linxz
 * 创建日期：2020年05月12日 20:31
 * version：v4.5.4
 * 描述：
 */
public class Phone implements Mp4Interface , MP3Interface  {

    @Override
    public void play() {
        System.out.println("HHHH");
    }

    public static void main(String[] args) {
        Phone phone=new Phone();
        System.out.println(phone instanceof MP3Interface);
        System.out.println(phone instanceof Mp4Interface);
        phone.play();
    }
}
