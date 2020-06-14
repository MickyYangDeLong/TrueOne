package study.leetcode.middle.bar;

import study.leetcode.utils.Threads;

import java.util.concurrent.TimeUnit;

//1115. 交替打印FooBar
public class FooBar002 {
    private int n;
    private volatile boolean IS_FIRST_START = true;

    public FooBar002(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (this) {
            IS_FIRST_START = false;
            for (int i = 0; i < n; i++) {
                printFoo.run();
                this.notify();
                this.wait();
            }
            this.notify();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            if (IS_FIRST_START) {
                this.wait();
            }
            for (int i = 0; i < n; i++) {
                printBar.run();
                this.notify();
                this.wait();
            }
            this.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            testUnit(i);
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println();
        }
    }

    private static void testUnit(int n) {
        FooBar002 f = new FooBar002(n);
        new Thread(() -> {
            try {
                Threads.setName(n + " f.bar=>");
                f.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Threads.setName(n + " f.foo=>");
                f.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
