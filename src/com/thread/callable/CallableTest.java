package com.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建异步任务
        FutureTask<String> future = new FutureTask(new CallableTest());
        //执行异步任务
        (new Thread(future)).start();
        //获取执行结果
        System.out.println(future.get());
    }

    @Override
    public String call() throws Exception {
        return "zmc";
    }
}
