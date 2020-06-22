package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class SynchronizedClass {
    // 修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("test1 %d - %d", j, i));
        }
    }
    // 修饰一个类
    public static void test1(int j) {
        synchronized (SynchronizedClass.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("test1 %d - %d", j, i));
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedClass example1 = new SynchronizedClass();
        SynchronizedClass example2 = new SynchronizedClass();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
