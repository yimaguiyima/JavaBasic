package com.thread.publish;

import com.thread.annoations.NotThreadSafe;

import java.util.Arrays;

@NotThreadSafe
public class UnsafePublic {
    private String[] states = {"a","b","c"};
    public String[] getStates(){
        return states;
    }
    public static void main(String[] args) {
        UnsafePublic unsafePublic = new UnsafePublic();
        System.out.println(String.format("%s", Arrays.toString(unsafePublic.getStates())));
        String[] ss = unsafePublic.getStates();
        ss[2] = "d";
        System.out.println(String.format("new %s", Arrays.toString(unsafePublic.getStates())));
    }
}
