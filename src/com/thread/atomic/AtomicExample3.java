package com.thread.atomic;

import com.thread.annoations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

@ThreadSafe
public class AtomicExample3 {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static AtomicBoolean count = new AtomicBoolean();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        add();
                        semaphore.release();
                    } catch (Exception e) {
                        //log.error("exception", e);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(String.format("count %s",count));
    }

    private static void add() {
        if(count.compareAndSet(false,true)){
            System.out.println(String.format("execute"));
        }
    }
}
