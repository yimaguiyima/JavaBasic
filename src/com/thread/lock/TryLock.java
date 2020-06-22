package com.thread.lock;

import com.thread.synchronize.MySynchronizedMethod;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    private static Lock rwl = new ReentrantLock();
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static void main(String[] args) throws InterruptedException {
        // defined lock object
        // two thread for lock,first get lock sleep(1000)
        long start = System.currentTimeMillis();
        //TryLock mySynchronized = new TryLock();
         new Thread(){
            @Override
            public void run() {
                if(rwl.tryLock()){
                    try {
                        System.out.println(Thread.currentThread().getName()+"获取锁");
//                        long start = System.currentTimeMillis();
//                        while(System.currentTimeMillis() -start <=10){
//                            //System.out.println(currentThread.getName() + "正在进行读操作");
//                        }
                        for (int i = 0; i < 5; i++) {
                            arrayList.add(i);
                        }
                    }finally {
                        System.out.println(Thread.currentThread().getName()+"释放锁");
                        rwl.unlock();
                    }
                }
            }
        }.start();
         new Thread(){
            @Override
            public void run() {
                if(rwl.tryLock()){
                    try {
                        System.out.println(Thread.currentThread().getName()+"获取锁");
                        long start = System.currentTimeMillis();
//                        while(System.currentTimeMillis() -start <=10){
//                            //System.out.println(currentThread.getName() + "正在进行读操作");
//                        }
                        for (int i = 0; i < 5; i++) {
                            arrayList.add(i);
                        }
                    }finally {
                        System.out.println(Thread.currentThread().getName()+"释放锁");
                        rwl.unlock();
                    }
                }
            }
        }.start();
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        System.out.println("time " + (System.currentTimeMillis() - start));
    }
    private void getByLock(Thread currentThread) {
        if(rwl.tryLock()){
            try {
                System.out.println(currentThread.getName()+"获取锁");
                long start = System.currentTimeMillis();
                while(System.currentTimeMillis() -start <=10){
                    //System.out.println(currentThread.getName() + "正在进行读操作");
                }
            }finally {
                System.out.println(currentThread.getName()+"释放锁");
                rwl.unlock();
            }
        }

    }
}
