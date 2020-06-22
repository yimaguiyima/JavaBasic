package com.thread.commonUnsafe;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
public class commonUnsafe {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static StringBuilder stringBuilder = new StringBuilder();
    public static StringBuffer stringBuffer = new StringBuffer();
    private static Set<Integer> set = new HashSet<>();
    private static Map<Integer, Integer> map = new HashMap<>();

//    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");
    private static List<Integer> list = new ArrayList<>();
    //private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    //log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(String.format("stringBuilder size:%d", stringBuilder.length()));
        System.out.println(String.format("stringBuilder size:%d", stringBuffer.length()));
        System.out.println(String.format("map size:%d", map.size()));
        System.out.println(String.format("set size:%d", set.size()));
        System.out.println(String.format("list size:%d", list.size()));
    }

    private static void update(int i) {
        stringBuilder.append("1");
        stringBuffer.append("1");
       // map.put(i, i);
        //set.add(i);
        //list.add(i,i);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180208");
        } catch (Exception e) {
//            log.error("parse exception", e);
        }
    }
}
