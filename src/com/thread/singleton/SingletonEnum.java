package com.thread.singleton;

public class SingletonEnum {
    //私有的构造函数
    private SingletonEnum(){}

    //静态工厂方法
    public static SingletonEnum getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonEnum instance = null;
        // JVM保证这个方法绝对只调用一次
        Singleton(){
            instance = new SingletonEnum();
        }

        public SingletonEnum getInstance() {
            return instance;
        }
    }
}
