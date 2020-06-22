package com.java8.stream;

import java.util.Random;

public class Randoms {
    //随机展示 5 至 20 之间不重复的、7个元素整数、进行排序、循环打印
    public static void main(String[] args) {
        new Random()
                .ints(5,20)
                .distinct()
                .limit(7)
                .sorted()
        .forEach(System.out::println);
        ICompare compare = new ICompare() {
        };
        compare.hello();
    }
}
