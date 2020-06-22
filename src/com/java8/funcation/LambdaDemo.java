package com.java8.funcation;

import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
        Collections.sort(list,(String a,String b)->b.compareTo(a));

        System.out.println(list);
    }
}
