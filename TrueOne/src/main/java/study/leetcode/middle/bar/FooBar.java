package study.leetcode.middle.bar;

import study.leetcode.utils.Threads;

import java.util.concurrent.Semaphore;
//1115. 交替打印FooBar
public class FooBar {
    private int n;
    private final Semaphore lock1 = new Semaphore(0);
    private final Semaphore lock2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock2.acquire();
            printFoo.run();
            lock1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock1.acquire();
            printBar.run();
            lock2.release();
        }
    }

    public static void main(String[] args) {
        FooBar f = new FooBar(5);
        new Thread(()->{
            try {
                Threads.setName("f.bar=>");
                f.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                Threads.setName("f.foo=>");
                f.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
