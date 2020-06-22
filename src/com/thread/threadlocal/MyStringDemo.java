package com.thread.threadlocal;

import java.util.concurrent.CountDownLatch;

public class MyStringDemo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        MyStringDemo demo = new MyStringDemo();
        //创建10 个线程，线程中设置name与读取name
        int num = 10;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for(int i =0;i<num;i++){
            (new Thread(()->{
                demo.setName(Thread.currentThread().getName());
                System.out.println(demo.getName());
                countDownLatch.countDown();
                },"thread-" + i)).start();
        }

    }
}
