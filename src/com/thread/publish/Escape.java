package com.thread.publish;

import com.thread.annoations.NotRecommend;
import com.thread.annoations.NotThreadSafe;

@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;
    public Escape () {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass(){
            System.out.println(String.format("%d",Escape.this.thisCanBeEscape));
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
