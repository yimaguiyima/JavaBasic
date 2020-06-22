package com.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamGenerators {
    public static void main(String[] args) {
        Stream stream = Stream.of("a","b","c");
        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        //stream = Stream.of(new String[] {"a", "b", "cd"});
        // Arrays.stream()
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
        stream.forEach(System.out::println);

        // reduce
        Optional<String> optional = Stream.of(strArray).sorted().reduce((a, b)->a + b);
        System.out.println(optional.get());
    }
}
