package com.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<String> queue;
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            String temp = queue.take();
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
