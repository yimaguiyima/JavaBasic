package com.thread.aqs;

import java.util.concurrent.*;

public class CyclicBarrierExample1 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

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
        Thread.sleep(100);
        System.out.println(String.format("%d is ready", threadNum));
        //cyclicBarrier.await();
        cyclicBarrier.await(20000, TimeUnit.MILLISECONDS);
        System.out.println(String.format("%d is continue", threadNum));
    }
}
