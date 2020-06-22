package com.thread.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample1 {
    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal  = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
//            exec.execute(() -> {
//                try {
//                    test(threadNum);
//                } catch (Exception e) {
//                    //log.error("exception", e);
//                } finally {
//                    doneSignal .countDown();
//                }
//            });
            exec.submit(new Worker(startSignal,doneSignal));
        }
        //countDownLatch.await();
        //countDownLatch.await(10, TimeUnit.MILLISECONDS);
        startSignal.countDown();
        doneSignal.await();
        System.out.println(String.format("finish"));
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        System.out.println(String.format("%d", threadNum));
        Thread.sleep(100);
    }
    static class Worker implements Runnable{

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                System.out.println(String.format("%d",doneSignal.getCount()));
                doneSignal.countDown();
            } catch (InterruptedException ex) {} // return;
        }
    }
}
