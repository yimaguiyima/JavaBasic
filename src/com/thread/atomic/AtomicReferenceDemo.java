package com.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    static AtomicReference<Integer> count = new AtomicReference<>(0);
    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        System.out.println(String.format("count:%d", count.get()));
        count.set(5);
        System.out.println(String.format("count:%d", count.get()));
    }
}
