package com.thread.aqs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskExample {
    static class Fibonacci extends RecursiveTask<Integer>{
        int n;

        public Fibonacci(int i) {
            n = i;
        }

        @Override
        protected Integer compute() {
            if(n == 0 || n==1){
                return n;
            }else {
                Fibonacci f1 = new Fibonacci(n-1);
                f1.fork();
                Fibonacci f2 = new Fibonacci(n-2);
                f2.fork();
                return f1.join() + f2.join();
            }
        }
    }

    static class ForkJoinTask1 extends RecursiveTask<Integer>{

        public static final int threshold = 2;
        private int start;
        private int end;

        public ForkJoinTask1(int i, int end) {
            this.start = i;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            boolean canCompute = (end - start)<=threshold;
            if(canCompute){
                //sum
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            }else{
                int middle = (start + end) / 2;
                ForkJoinTask1 f1 = new ForkJoinTask1(start,middle);
                f1.fork();
                ForkJoinTask1 f2 = new ForkJoinTask1(middle+1,end);
                f2.fork();
                sum = f1.join() + f2.join();
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        //Fibonacci fibonacci = new Fibonacci(40);
        ForkJoinTask1 fibonacci = new ForkJoinTask1(1,100);
        Future<Integer> future = pool.submit(fibonacci);
        long end = System.currentTimeMillis();
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
        System.out.println(future.get());
        System.out.println(String.format("耗时：%d millis", end - start));
    }
}
