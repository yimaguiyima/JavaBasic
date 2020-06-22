package com.thread.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample2 {
    private final static int threadCount = 20;
    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(1); // 获取多个许可
                    test(threadNum);
                    semaphore.release(1); // 释放多个许可
                } catch (Exception e) {
                   // log.error("exception", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        System.out.println(String.format("%d", threadNum));
        Thread.sleep(1000);
    }

}
