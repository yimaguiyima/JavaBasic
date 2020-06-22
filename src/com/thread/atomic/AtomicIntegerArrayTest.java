package com.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    static int[] nums = { 1, 2, 3, 4, 5, 6 };
    static AtomicIntegerArray array = new AtomicIntegerArray(nums);
    static class AddThread implements Runnable{

        @Override
        public void run() {
            for(int k=0;k<6000;k++){
                array.getAndIncrement(k%array.length());
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temvalue = 0;
        for (int j = 0; j < nums.length; j++) {
            System.out.println(array.get(j));
        }
        temvalue = array.getAndSet(0, 2);
        System.out.println("temvalue:" + temvalue + ";  array:" + array);
        temvalue = array.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  array:" + array);
        temvalue = array.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  array:" + array);
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i =0;i<10;i++){
            pool.execute(new AddThread());
        }
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
        }
        System.out.println("pool:" + " array:" + array);
    }
}
