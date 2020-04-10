package com.linxz.DataStructure.stack;

import java.util.Stack;

public class 栈的应用 {

//    应用场景：
//            1.编译器撤销操作：Ctr+Z，撤销最近的一次操作。
//            2.程序调用的系统栈：
//    eg:func A()里面调用func B(),B()又调用func C()
//    A方法执行到B方法的时候中断，B方法执行到C方法的时候中断。
//    C方法执行完出栈，B方法恢复中断，B方法执行完出栈，A方法恢复中断
//3.括号匹配-编译器


    /**
     * { [ () ] } 字符串匹配
     * 遇到左边的符合 { [ ( 认为是正确的，并且入栈
     * 遇到右边的符合 ) ] } 则获取栈顶元素匹配，如果能正确匹配则认为是正确的，并且出栈
     * 一直匹配到整个栈元素为空，则表明整个字符串括号匹配是正确的
     * */
    public static boolean isValidate(String s){
        if (s==null){
            throw new IllegalArgumentException("s can no be null");
        }
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='{' || c=='[' || c=='('){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char topChar=stack.peek();
                if ((topChar=='{' && c=='}') || (topChar=='[' && c==']') || (topChar=='(' && c==')')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s="{[()]}";
        System.out.println(isValidate(s));
    }

}