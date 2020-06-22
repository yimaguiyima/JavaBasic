package com.thread.synchronize;

public class MySynchronized {
    public static void main(String[] args) {
        // defined lock object
        // two thread for lock,first get lock sleep(1000)
        MySynchronized mySynchronized = new MySynchronized();
        new Thread(){
            @Override
            public void run() {
                synchronized (mySynchronized){
                try {
                    //Thread.sleep(1000);
                    mySynchronized.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 0: start; ");}
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synchronized (mySynchronized){
                System.out.println("thred 1: start");}
            }
        }.start();
    }
}
