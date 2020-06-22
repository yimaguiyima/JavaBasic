package com.thread;

public class ThreadTest {
    static class Threadtest extends Thread{
        long minPrime;
        public Threadtest(long minPrime) {
            this.minPrime = minPrime;
        }
        public void run(){
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(minPrime);
            }

        }
    }
    public static void main(String[] args){
        (new Threadtest(1L)).run();
        (new Threadtest(143L)).start();
    }
}
