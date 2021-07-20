package com;

import com.linxz.DataStructure.queue.LinkedQueue;
import com.linxz.DataStructure.queue.Queue;
import com.linxz.DataStructure.stack.LinkedStack;
import com.linxz.DataStructure.stack.Stack;

import java.util.concurrent.DelayQueue;

/**
 * @author Linxz
 * 创建日期：2021年04月19日 2:29 PM
 * version：
 * 描述：
 */
class TestMain {
    public static void main(String[] args) {
        //str1 str2

    }

    private void add(String str1,String str2){
       // int[] data1=new int[str1.length()];
       // int[] data2=new int[str2.length()];

        Stack<Integer> data1=new LinkedStack<>();
        Stack<Integer> data2=new LinkedStack<>();
        Queue<Integer> dataTotal=new LinkedQueue<>();

        for (int i=0;i<str1.length();i++){
           char mChar= str1.charAt(i);
            data1.push(Integer.parseInt(mChar+""));
        }
        for (int i=0;i<str2.length();i++){
            char mChar= str2.charAt(i);
            data2.push(Integer.parseInt(mChar+""));
        }

        if (data1.getSize()>data2.getSize()){
            Integer tempData2=data2.pop();
            boolean childTotalOver=false;
            while (tempData2 != null){
                Integer tempData1=data1.pop();
                int childTotal=tempData1.intValue()+tempData2.intValue();
                if (childTotalOver){
                    childTotal=childTotal+1;
                }
                if (childTotal>10){
                    //余数
                    childTotal=childTotal % 10;
                    childTotalOver=true;
                    dataTotal.enqueue(childTotal);
                }
            }
        }

        Integer temp=data1.pop();
        while (temp != null){
            dataTotal.enqueue(temp);
        }

        StringBuilder sb=new StringBuilder("0");
        Integer tempTotal=dataTotal.dequeue();
        while (tempTotal != null){
            sb.append(tempTotal);
            tempTotal=dataTotal.dequeue();
        }
    }


}
