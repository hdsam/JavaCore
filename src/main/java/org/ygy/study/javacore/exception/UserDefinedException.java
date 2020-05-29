package org.ygy.study.javacore.exception;

import org.ygy.study.javacore.exception.myException.LoginFailedException;

/**
 * 自定义异常
 */
public class UserDefinedException {

    public static void main(String[] args) {
        String password = "321";
        if(!"123".equals(password)){
            throw new LoginFailedException();
        }
    }


}
