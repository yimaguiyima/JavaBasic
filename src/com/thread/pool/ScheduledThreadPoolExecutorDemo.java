package com.thread.pool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule run");
            }
        }, 1, 3, TimeUnit.SECONDS);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer run");
            }
        }, new Date(), 5 * 1000);

    }
}
