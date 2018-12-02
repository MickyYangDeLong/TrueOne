package servlet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestArrraySort {
    public static void main(String[] args) {
        int[] a = {11,3,998,5445,1,152,990};
        ExecutorService executorService = Executors.newFixedThreadPool(a.length);
        for(int aa : a){
            executorService.submit(new ArraySort(aa));
        }
    }
}

class ArraySort implements Runnable{
    final int a;
    ArraySort(int a){
        this.a = a;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MICROSECONDS.sleep(Long.valueOf(this.a*1000));
           // TimeUnit.NANOSECONDS.sleep(1);
            System.out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
