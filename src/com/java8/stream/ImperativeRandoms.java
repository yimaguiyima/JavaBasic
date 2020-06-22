package com.java8.stream;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class ImperativeRandoms {
    //随机展示 5 至 20 之间不重复的、7个元素整数、进行排序、循环打印
    //命令式
    public static void main(String[] args) {
        Random random = new Random();
        SortedSet<Integer> sortedSet = new TreeSet<Integer>();
        while (sortedSet.size()<7){
            int r = random.nextInt(20);
            if(r < 5) continue;
            sortedSet.add(r);
        }
        System.out.println(sortedSet);
    }
}
