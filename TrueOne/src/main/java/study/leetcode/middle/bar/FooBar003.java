package study.leetcode.middle.bar;

import study.leetcode.utils.Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//1115. 交替打印FooBar
public class FooBar003 {
    private int n;
    private volatile boolean IS_FIRST_START = true;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public FooBar003(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            IS_FIRST_START = false;
            for (int i = 0; i < n; i++) {
                printFoo.run();
                condition.signal();
                condition.await();
            }
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {
            if (IS_FIRST_START) {
                condition.await();
            }
            for (int i = 0; i < n; i++) {
                printBar.run();
                condition.signal();
                if (i < (n - 1)) {
                    condition.await();
                }
            }
            condition.signal();
        } finally {
            lock.unlock();
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
        FooBar003 f = new FooBar003(n);
        new Thread(() -> {
            try {
                Threads.setName(n+" f.bar=>");
                f.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Threads.setName(n+ " f.foo=>");
                f.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
