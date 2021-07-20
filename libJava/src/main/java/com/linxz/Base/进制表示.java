package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2021年01月11日 23:06
 * version：
 * 描述：
 */
public class 进制表示 {

    //二进制(0b开头)
    private final static int BYTE_2_10 = 0b1010;
    //八进制(0开头)
    private final static int BYTE_8_10 = 012;
    //十六进制(0x开头)
    private final static int BYTE_16_10 = 0xa;





    //2 n 次方使用左移表示
    //2 n 次方 <= m,输入m，找出n的最大
    //>>有符号左移   >>>无符号左移
    //>> 表示右移，如果该数为正，则高位du补0，若为负数zhi，则高位补1。如：int i=15; i>>2的结dao果是3，移出的部分将被抛弃。
    //>>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0

    public static int min(int target) {
        target |= target >> 1;
        target |= target >> 2;
        target |= target >> 4;
        target |= target >> 8;
        target |= target >> 16;
        return target - (target >> 1);
    }


    public static void main(String[] args) {
//        System.out.println(BYTE_2_10);
//        System.out.println(BYTE_8_10);
//        System.out.println(BYTE_16_10);
        System.out.println(min(17));
    }
}
