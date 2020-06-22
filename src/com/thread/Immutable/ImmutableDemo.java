package com.thread.Immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableDemo {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = new HashMap();
    private static Map<Integer, Integer> map1 = new HashMap();
    static {
        map1.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map1 = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        map = new HashMap();
       // map.put(1, 3);
        map1.put(1, 3);
//        log.info("{}", map.get(1));
        System.out.println(String.format("%d",map.get(1)));
    }
}
