package org.ygy.study.javacore.junit.lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.fact(-1);
        });

    }
    @Test
    void testOverflow(){
       assertThrows(ArithmeticException.class, () -> {
           Factorial.fact(21);
       });
    }
}