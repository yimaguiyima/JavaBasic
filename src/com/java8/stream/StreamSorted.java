package com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StreamSorted {
    public static void main(String[] args) {
        // test data
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // Sequential Sort
//        long start = System.nanoTime();
//        values.stream().sorted().count();
//        long end = System.nanoTime();
//        System.out.println(String.format("sequential sort took: %d ms", end-start));
        //Parallel sort
        long start = System.nanoTime();
        values.parallelStream().sorted().count();
        long end = System.nanoTime();
        System.out.println(String.format("sequential sort took: %d ms", end-start));

    }
}
