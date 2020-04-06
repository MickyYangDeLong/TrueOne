package dump.deadlock;

import java.util.concurrent.*;

public class DeadLockDemo {
    private Object o1 = new Object();
    private Object o2 = new Object();
    public static void main(String[] args) {
        DeadLockDemo testDeadLock =new DeadLockDemo();
        new Thread(()->{
            Thread.currentThread().setName("--------------11111111111-------------");
            try {
                testDeadLock.m1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            Thread.currentThread().setName("--------------22222222222----");
            try {
                testDeadLock.n1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
   private void m1() throws InterruptedException {
        synchronized (o1){
            System.out.println(getThreadName()+"-- m1 start sleep o1!");
            TimeUnit.SECONDS.sleep(10);
            n1();
            System.out.println(getThreadName()+"-- m1 end sleep o1!");
        }
    }

    private void n1() throws InterruptedException {
        synchronized (o2){
            System.out.println(getThreadName()+"-- n1 start sleep o2!");
            TimeUnit.SECONDS.sleep(10);
            m1();
            System.out.println(getThreadName()+"-- n1 end sleep o2!");
        }
    }

    static String getThreadName(){
        return  Thread.currentThread().getName();
    }

}
