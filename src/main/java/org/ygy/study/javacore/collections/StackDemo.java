package org.ygy.study.javacore.collections;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈（Stack）是一种后进先出（FILO:first in last out）的数据结构
 * 把队列的一段封死，即可实现最后进栈的元素一定最早出栈。
 * Java中，旧的Stack类已不推荐使用，推荐使用Deque来实现栈的功能:
 *   <pre>
 *      把元素压栈 ：push(E) / addFirst(E);
 *      把栈顶的元素“弹出” ：pop() /removeFirst();
 *      取出栈顶元素但不“弹出”： peek()/peekFirst();
 *   </pre>
 * Dequeu作为栈使用时，建议只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更清晰。
 */
public class StackDemo {

    public static void main(String[] args) {
//        baseDemo();

        applyingStack();

    }

    private static void baseDemo() {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void applyingStack(){
        int num = 12500;
        String hexString = toHex(num);
        System.out.println(String.format("%s 的16进制表示为：%s", num, hexString) );

    }

    /**
     * 10进制转换为16字符串
     * @param num 十进制数
     * @return 十六进制字符串
     */
    private static String toHex(int num) {
        final String hexChars = "0123456789ABCDEF";
        Deque<String> stack = new LinkedList<>();
        int  i = num;
        while(true){
            int rem = i % 16;
            stack.push(hexChars.charAt(rem) + "");
            if((i = i / 16) == 0){
                break;
            }
        }
        StringBuilder hexResult = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            hexResult.append(stack.pop());
        }
        return hexResult.toString();
    }
}
