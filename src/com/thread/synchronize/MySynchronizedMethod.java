package com.thread.synchronize;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MySynchronizedMethod {
//    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private ReentrantLock rwl = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        // defined lock object
        // two thread for lock,first get lock sleep(1000)
        long start = System.currentTimeMillis();
        MySynchronizedMethod mySynchronized = new MySynchronizedMethod();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                mySynchronized.get(Thread.currentThread());
            }
        };
       Thread t2 = new Thread(){
            @Override
            public void run() {
                mySynchronized.get(Thread.currentThread());
            }
        };
       t1.start();
       t2.start();
       t1.join();
       t2.join();
        System.out.println("time " + (System.currentTimeMillis() - start));
    }

    private synchronized void get(Thread currentThread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() -start <=10){
            System.out.println(currentThread.getName() + "正在进行读操作");
        }
        System.out.println(currentThread.getName()+"读操作完毕");
    }
    private void getByLock(Thread currentThread) {
        rwl.lock();
        try {
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() -start <=10){
                System.out.println(currentThread.getName() + "正在进行读操作");
            }
            System.out.println(currentThread.getName()+"读操作完毕");
        }finally {
            rwl.unlock();
        }
    }
}
