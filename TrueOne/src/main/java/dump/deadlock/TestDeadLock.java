package dump.deadlock;
import java.util.concurrent.TimeUnit;

public class TestDeadLock {

    public static void main(String[] args) {
        TestDeadLock testDeadLock =new TestDeadLock();
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


    Object o1 = new Object();
    Object o2 = new Object();
    void m1() throws InterruptedException {
        synchronized (o1){
            System.out.println(getThreadName()+"-- m1 start sleep o1!");
            TimeUnit.SECONDS.sleep(5);
            n1();
            System.out.println(getThreadName()+"-- m1 end sleep o1!");
        }
    }

    void m2() throws InterruptedException {
        synchronized (o1){
            System.out.println(getThreadName()+"--m2 start sleep o1!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(getThreadName()+"-- m2 end sleep o1!");
        }
    }

    void n1() throws InterruptedException {
        synchronized (o2){
            System.out.println(getThreadName()+"-- n1 start sleep o2!");
            TimeUnit.SECONDS.sleep(5);
            m1();
            System.out.println(getThreadName()+"-- n1 end sleep o2!");
        }
    }

    void n2() throws InterruptedException {
        synchronized (o2){
            System.out.println(getThreadName()+"-- n2 start sleep o2!");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(getThreadName()+"-- n2 end sleep o2!");
        }
    }

    static String getThreadName(){
        return  Thread.currentThread().getName();
    }



}