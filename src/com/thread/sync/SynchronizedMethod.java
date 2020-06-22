package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMethod {
    // 修饰一个代码块
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("test1 %d ", i));
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("test1 %d - %d", j, i));
        }
    }

    public static void main(String[] args) {
        SynchronizedMethod syncMethod = new SynchronizedMethod();
        SynchronizedMethod syncMethod1 = new SynchronizedMethod();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncMethod.test2(2);
        });
        executorService.execute(() -> {
            syncMethod1.test2(2);
        });
    }
}
