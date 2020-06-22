package com.thread.singleton;

import com.thread.annoations.NotThreadSafe;

//懒汉模式，在第一次使用时才进行创建
@NotThreadSafe
public class SingletonExample {
    //私有的构造函数
    private SingletonExample(){}
    // 私有，静态，单例对象
    private static SingletonExample instance = null;
    //静态工厂方法
    public static SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }
        return instance;
    }
}
