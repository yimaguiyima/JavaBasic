package com.thread.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        System.out.println(String.format("callback is running"));
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    //log.error("exception", e);
                }
            });
            //exec.submit(new CountDownLatchExample1.Worker(startSignal,doneSignal));
        }
        System.out.println(String.format("finish"));
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(String.format("%d is ready", threadNum));
        cyclicBarrier.await();
        System.out.println(String.format("%d is continue", threadNum));
    }
}
