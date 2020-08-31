package org.ygy.study.javacore.junit.lesson4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigTest {

    Config config;

    @BeforeEach
    void setUp(){
        config = new Config();
    }

    @AfterEach
    void tearDown(){
        config = null;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindows(){
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testLinuxAndMac(){
        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    void testOnNonWindowsOs(){
        //TODO : this test is disabled on windows
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testOnJava9OrAbove(){
        //TODO : this test is disabled on Java8
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testOnlyOn64BitSystem(){
        //TODO : this test is only running on 64 bit system
        System.out.println(System.getProperty("os.arch"));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")
    void testOnlyOnDebugMode(){
        //TODO : this test is only running on DEBUG = true

    }

}