package com.thread.singleton;

import com.thread.annoations.ThreadSafe;

//懒汉模式
@ThreadSafe
public class SingletonLayz {
    //私有的构造函数
    private SingletonLayz(){}
    // 私有，静态，单例对象
    private static volatile SingletonLayz instance = null;
    //静态工厂方法
    //双锁模式,synchronized 下沉
    public static SingletonLayz getInstance(){
        if(instance == null){// 双重检测机制        // B
            synchronized (SingletonLayz.class){// 同步锁
                if(instance == null){
                    instance = new SingletonLayz();// A - 3
                }
            }
        }
        return instance;
    }
}
