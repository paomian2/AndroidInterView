package com.tencent_class.泛型;

/**
 * @author Linxz
 * 创建日期：2021年03月11日 11:43 PM
 * version：
 * 描述：
 */
class 泛型类TestMain {

    static class  Pair<T>{
        private T value;
        public void setValue(T t){
            this.value=t;
        }
        public T getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        Pair<String> pair=new Pair<>();
        pair.setValue("潘金莲");
        System.out.println(pair.getValue());
    }
}
