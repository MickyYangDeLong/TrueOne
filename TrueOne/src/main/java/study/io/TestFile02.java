package study.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class TestFile02 {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("F:\\TrueOne\\Second-sys\\springboot-seckill\\src\\main\\java\\guhao\\test\\TestFile02.java")));
                while (in.available()!=0)
                    System.out.println(in.readLine());
            // String.valueOf()"".toCharArray();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
