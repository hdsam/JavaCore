package org.ygy.study.javacore.junit.lesson2;

public class Caculator {

    private long n = 0;

    public long add(long x){
        n = n + x;
        return  n;
    }

    public long sub(long x){
        n = n - x;
        return n;
    }

}
