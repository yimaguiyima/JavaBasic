package com.java8.funcation;

import java.util.function.Function;
import java.util.function.Predicate;

public class BuiltInFunction {
    public static void main(String[] args) {
        Function<String,Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(toInteger.apply("123"));

        Predicate<String> predicate = (s)->s.length()>0;
        System.out.println(predicate.test("foo"));

    }
}
