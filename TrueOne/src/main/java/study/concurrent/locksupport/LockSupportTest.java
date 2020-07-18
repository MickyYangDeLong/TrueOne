package study.concurrent.locksupport;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;


/**
 * 测试LockSupport的功能
 * @Auther Micky
 * @Date 2020-07-12 15:30
 */
public class LockSupportTest {
    static ExecutorService executorService = new ThreadPoolExecutor(2,2,0
    ,TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            Thread.currentThread().setName("thread-----------------0");
            System.out.println("begin thread 0000000000");
            LockSupport.park();
            System.out.println();
            System.out.println("end thread 0000000000");
        });

        Thread thread2 = new Thread(()->{
            Thread.currentThread().setName("thread-----------------1");
            System.out.println("begin thread 11111111111");
            LockSupport.park(thread);
            System.out.println();
            System.out.println("end thread 111111111111");
        });
        System.out.println("all begin=========");
        thread.start();
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println("all unpark!");
        LockSupport.unpark(thread);
        LockSupport.unpark(thread2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("all end=========");




    }


}
