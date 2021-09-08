package com.tencent_class;

/**
 * @author Linxz
 * 创建日期：2021年08月04日 5:37 PM
 * version：
 * 描述：
 */
public class TestCl {
    public static void main(String[] args) {
        new ChildComponent();
    }
}

class LifeCycle {
    String string;
    public LifeCycle(String string) {
        this.string = string;
        System.out.println("lifeCycle:"+string);
    }
    public void print() {
        System.out.println("==========" + string);
    }
}

class Component {
    final  LifeCycle lifeCycle = new LifeCycle("Compment");
    public Component() {
        System.out.println("========Componment==" );
        LifeCycle lifecycle = getLifeCycle();
//        if (lifecycle == null) {
//            throw new IllegalStateException("getLifecycle() returned null in Component");
//        }
//        getLifeCycle().print();
    }

    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }
}

class ChildComponent extends Component {
    final LifeCycle lifeCycle = new LifeCycle("ChildCompement");
    public ChildComponent(){
        super();
        System.out.println("========ChildCompement==" );
    }
    @Override
    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }
}


class HostCallbacks{

}