package org.ygy.study.javacore.junit.lesson5;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 参数化测试
 */
public class ParamtersTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }

    @ParameterizedTest
    @MethodSource("testCapitalize")  //如果静态方法的名称和测试方法的方法名相同，则此处可以不用指定作为输入参数得方法名
    void testCapitalize(String input, String result){
        assertEquals(result, StringUtils.captialize(input));
    }

   static List<Arguments> testCapitalize(){
        List<Arguments> args = new ArrayList<>();
        args.add(Arguments.arguments("abc","Abc"));
        args.add(Arguments.arguments("APPLE","Apple"));
        args.add(Arguments.arguments("XyZ","Xyz"));
        return args;
    }

    @ParameterizedTest
    @CsvSource({"abc,Abc", "APPLE,Apple", "XyZ,Xyz"})
    void testCapitalizeUsingCsv(String input, String result){
        assertEquals(result, StringUtils.captialize(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test-capitalize.csv")
    void testCapitalizeUsingCsvFile(String input, String result){
        assertEquals(result, StringUtils.captialize(input));
    }

}
