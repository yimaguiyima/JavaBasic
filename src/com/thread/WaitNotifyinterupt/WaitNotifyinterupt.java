package com.thread.WaitNotifyinterupt;

//thread wait,interupt ,InterruptedException
public class WaitNotifyinterupt {
    static Object obj = new Object();
    public static void main(String[] args) {
        Thread te = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("Thread wait");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        te.start();
        te.interrupt();

    }
}
