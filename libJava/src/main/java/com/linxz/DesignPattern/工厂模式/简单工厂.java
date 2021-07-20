package com.linxz.DesignPattern.工厂模式;

/**
 * @author Linxz
 * 创建日期：2021年01月20日 10:20
 * version：
 * 描述：
 * <p>
 * https://www.runoob.com/design-pattern/factory-pattern.html
 *
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 *
 * 我们明确地计划不同条件下创建不同实例时
 *
 * 优点： 1、一个调用者想创建一个对象，只要知道其名称就可以了。 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 3、屏蔽产品的具体实现，调用者只关心产品的接口。
 *
 * 缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
 *
 * 根据参数确定生产什么类型的手机
 */
public class 简单工厂 {


    //网上很多定义Phone是接口，但是感觉使用抽象类更符合我们的思维。(产品是实实在在的物体，而接口类似是一种协议，非实物)
    public static abstract class Phone {
        //手机厂商
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private void call(String phoneNum) {
            System.out.println("拨打电话：" + phoneNum);
        }

       public abstract void launch();
    }


    public static class HuaweiPhone extends Phone {
        public HuaweiPhone(){
            setName("华为手机");
        }
        @Override
        public void launch() {
            System.out.println("启动华为手机");
        }
    }

    public static class XiaomiPhone extends Phone {
        public XiaomiPhone(){
            setName("小米手机");
        }
        @Override
        public void launch() {
            System.out.println("启动小米手机");
        }
    }


    public static class Factory {
        public static Phone create(String arg) {
            switch (arg) {
                case "Huawei":
                    return new HuaweiPhone();
                case "Xiaomi":
                    return new XiaomiPhone();
                default:
                    break;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Phone phone=Factory.create("Xiaomi");
        phone.launch();
        phone.call("110");
    }
}
