package com.linxz.DesignPattern.工厂模式;

/**
 * @author Linxz
 * 创建日期：2021年01月20日 11:26
 * version：
 * 描述：
 * https://www.runoob.com/design-pattern/abstract-factory-pattern.html
 * 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 *
 * 系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
 *
 * 手机:华为手机、小米手机
 * 手环:华为手环、小米手环
 *
 */
public class 抽象工厂 {

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


    public static abstract class Bracelet {
        //手环厂商
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private void walkNum(int walkNum) {
            System.out.println("走路步数：" + walkNum);
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


    public static class HuaweiBracelet extends Bracelet {
        public HuaweiBracelet(){
            setName("华为手环");
        }
        @Override
        public void launch() {
            System.out.println("启动华为手环");
        }
    }

    public static class XiaomiBracelet extends Bracelet {
        public XiaomiBracelet(){
            setName("小米手环");
        }
        @Override
        public void launch() {
            System.out.println("启动小米手环");
        }
    }

    public static abstract class AbstractFactory{
        public abstract Phone createPhone(String arg);
        public abstract Bracelet createBracelet(String arg);
    }

    public static class PhoneFactory extends AbstractFactory{

        @Override
        public Phone createPhone(String arg) {
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

        @Override
        public Bracelet createBracelet(String arg) {
            return null;
        }
    }

    public static class BraceletFactory extends AbstractFactory{

        @Override
        public Phone createPhone(String arg) {
            return null;
        }

        @Override
        public Bracelet createBracelet(String arg) {
            switch (arg) {
                case "Huawei":
                    return new HuaweiBracelet();
                case "Xiaomi":
                    return new XiaomiBracelet();
                default:
                    break;
            }
            return null;
        }
    }

    public static class Factory{
        public static AbstractFactory getFactory(String choice){
           switch (choice){
               case "Phone":
                   return new PhoneFactory();
               case "Bracelet":
                   return new BraceletFactory();
               default:
                   break;
           }
           return null;
        }
    }

    public static void main(String[] args) {
        Phone phone=Factory.getFactory("Phone").createPhone("Huawei");
        phone.launch();
        phone.call("110");
    }
}
