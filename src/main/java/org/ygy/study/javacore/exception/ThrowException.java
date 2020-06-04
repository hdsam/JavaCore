package org.ygy.study.javacore.exception;

/**
 * 抛出异常
 */
public class ThrowException {

    public static void main(String[] args) {
//        m2();

//        f1();

//        try {
//                t1(); //异常打印日志中可以看到Caused by:xxx,指明了异常的问题的根源。e.getCause()可以看到异常的原因，若返回"null"则表明该异常是根异常
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println(e.getCause());
//        }

//        d();

//        c();

        try {
            s();
        }catch (Exception e){
            System.out.println(e.getSuppressed());
        }
    }

    ////////////////////////////////////////Segement 3 异常抛出 ////////////////////////////////////////////////////////////////////

    static void m1() {
        Integer.parseInt("\u0041");
    }

    static void m2() {
        m1();  //当一个方法内部没有捕获异常，异常就会被抛到调用上层
    }

    /////////////////////////////////////Segement 2 异常类型转换///////////////////////////////////////////////////

    static void f1() {
        try {
            f2();
        } catch (NullPointerException e) {
            System.out.println(e.getCause());
            throw new IllegalArgumentException(); //异常类型发生了转换，但丢失了异常信息
        }
    }

    static void f2() {
        throw new NullPointerException();
    }


    ///////////////////////////////////////Segement 3 异常类型转换并记录原始异常堆栈///////////////////////////////////

    static void t1() {
        try {
            t2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e); //构造异常时把旧的异常实例传递进去，异常类型发生了转换，但持有了原有的异常堆栈信息
        }
    }

    static void t2() {
        throw new NullPointerException();
    }

    ///////////////////////////////////////Segement 4 finally代码块/////////////////////////////////////////////////////////////////////////


    static void d(){
        try {
            Integer.parseInt("d");
        }catch (Exception e){
            System.out.println("catched!!!");
            throw  new RuntimeException("发了异常" , e);
        }finally {  //无论catch
            System.out.println("finally");
        }
    }

    /////////////////////////////////////Segement 5 异常覆盖///////////////////////////////////////////////////////////////////

    static void c(){
        try {
            Integer.parseInt("c");
        }catch (Exception e){
            System.out.println("catched!!!");
            throw new RuntimeException("发了异常" , e);
        }finally {  //无论catch
            System.out.println("finally");
            throw  new IllegalArgumentException("参数异常"); //finally中的异常会覆盖catch中的异常，因为异常一个方法中运行时只能抛出一个，
                                                            //没有被抛出的异常称为“被屏蔽”的异常（Suppressed Exception）
        }
    }

    static void s(){
        Exception origin = null;
        try {
            Integer.parseInt("s");
        }catch (NumberFormatException e){
            origin = e;
            throw  e;
        }finally {
            IllegalArgumentException e2 = new IllegalArgumentException();
            if (origin != null) {
                e2.addSuppressed(origin);
            }
            throw e2;  //绝大对数情况下，finally中不要抛异常，所以这种方法并不常用
        }

    }
}
