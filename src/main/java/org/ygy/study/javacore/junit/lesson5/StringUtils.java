package org.ygy.study.javacore.junit.lesson5;

public class StringUtils {

    public static String captialize(String s){
        if(s.length() == 0){
            return  s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
