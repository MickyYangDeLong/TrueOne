package servlet;

import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) throws  Exception{
        long dateNow = new Date().getTime();
        System.out.println(TimeZone.getDefault().getRawOffset());
        long nowTime = dateNow%(24*3600000)+TimeZone.getDefault().getRawOffset();
        System.out.println(nowTime);
        System.out.println(nowTime/3600000);
        System.out.println((nowTime%3600000)/60000);
    }
}
