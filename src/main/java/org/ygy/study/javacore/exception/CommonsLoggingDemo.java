package org.ygy.study.javacore.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Apache commons logging三方日志库 <br>
 *     默认情况下，Commons Logging自动搜索并使用Log4j（Log4j是另一个流行的日志系统），如果没有找到Log4j，再使用JDK Logging。
 *     定义了6个日志级别：
 *     FATAL
 *     ERROR
 *     WARNING
 *     INFO（默认级别）
 *     DEBUG
 *     TRACE
 */
public class CommonsLoggingDemo {

    static final Log LOG_STATIC = LogFactory.getLog(CommonsLoggingDemo.class); //提供给静态方法内部使用

    public static void main(String[] args) {
        Person person = new Person();
        person.foo();

    }

}

class Person {

    protected final Log LOG = LogFactory.getLog(getClass()); //提供给实例方法使用

    void foo() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            LOG.error("发了异常", e);
        }
    }

}

class  Student extends  Person{

    void bar(){
        LOG.info("test"); //这里的LOG = LOGFactory.getLog(Student.class);
    }
}