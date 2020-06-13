package org.ygy.study.javacore.io;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 */
public class FilterInputStreamDemo {

    public static void main(String[] args) throws IOException {

        byte[] data = "Hello world".getBytes(StandardCharsets.UTF_8);
        try (CountInputStream in = new CountInputStream(new ByteArrayInputStream(data))) {

            int n ;
            while ((n = in.read()) != -1){
                System.out.println((char)n);
            }

            System.out.println("total read bytes : " + in.getBytesRead());
        }
    }


}

/**
 * 自定义一个可以计数的输入流
 */
class CountInputStream extends FilterInputStream{

    private int count = 0 ;

    public CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead(){
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = super.read();
        if (n != -1) {
            this.count++ ;
        }
        return n;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int n = super.read(b);
        if(n != -1) {
            this.count++;
        }
        return n;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = super.read(b, off, len);
        if(n != -1){
            this.count++;
        }
        return n;
    }
}