package org.ygy.study.javacore.junit.lesson2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CaculatorTest {

    Caculator caculator ;

    @BeforeAll //会在所有@Test注解标识的方法前仅运行一次，常用来初始化静态遍量
    static void start(){
        System.out.println("开始整体测试");
    }

    @AfterAll //会在所有@Test注解标识的方法后仅运行一次
    static void destory(){
        System.out.println("结束整体测试");
    }


    @BeforeEach //会在每个@Test注解标识的方法执行前执行一次
    void setUp() {
        System.out.println("CaculatorTest.setUp");
        this.caculator = new Caculator();
    }

    @AfterEach //会在每个@Test注解标识的方法执行后执行一次
    void tearDown() {
        System.out.println("CaculatorTest.tearDown");
        this.caculator = null;
    }

    @Test
    void add() {
        System.out.println("CaculatorTest.add");
        assertEquals(100, this.caculator.add(100));
        assertEquals(300, this.caculator.add(200));
        assertEquals(270, this.caculator.add(-30));
    }

    @Test
    void sub() {
        System.out.println("CaculatorTest.sub");
        assertEquals(-100, this.caculator.sub(100));
        assertEquals(-200, this.caculator.sub(100));
        assertEquals(-250, this.caculator.sub(50));
    }
}