package com.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i = 1;i<5;i++){
            Future<String> future = pool.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return "b";
                }
            });
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
