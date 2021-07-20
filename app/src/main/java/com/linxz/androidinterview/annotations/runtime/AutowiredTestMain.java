package com.linxz.androidinterview.annotations.runtime;

/**
 * @author Linxz
 * 创建日期：2021年04月07日 4:12 PM
 * version：
 * 描述：
 */
class AutowiredTestMain {

    @Autowired
    Studet studet;


    public static void main(String[] args) {
        AutowiredTestMain autowiredTestMain=new AutowiredTestMain();
        InjectUtils.injectObj(autowiredTestMain);
        autowiredTestMain.studet.say();

    }
}
