package com.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        // 实例化、取当前值和 stamp 值
        final Integer initialRef = 0, initialStamp = 0;
        final AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(initialRef, initialStamp);
        System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

        final boolean casResult = asr.compareAndSet(initialRef, initialRef+20, initialStamp, initialStamp+1);
        if(casResult){
            System.out.println("currentValue=" + asr.getReference()
                    + ", currentStamp=" + asr.getStamp());
        }
    }
}
