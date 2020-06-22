package com.thread.WaitNotifyinterupt;

public class DeadLockDemo {
    //死锁，两个线程 都需要a,b资源，线程1得到a,线程2获取b,都不释放，都无法进行
    static Object objA = new Object();
    static Object objB = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA){
                    System.out.println("t1 had get objA");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objB){
                        System.out.println("t1 had runned");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objB){
                    System.out.println("t2 had get objB");
                    synchronized (objA){

                        System.out.println("t2 had runned");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
