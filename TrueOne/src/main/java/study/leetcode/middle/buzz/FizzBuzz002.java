package study.leetcode.middle.buzz;

import java.util.function.IntConsumer;

// 1195. 交替打印字符串
class FizzBuzz002 {
    private int n;
    private volatile int index = 1;

    public FizzBuzz002(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        if (n < 1) {
            return;
        }
        while (index <= n && !Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                if (0 != (index % 5) && 0 == (index % 3)) {
                    printFizz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }


    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        if (n < 1) {
            return;
        }
        while (index <= n && !Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                if (0 != (index % 3) && 0 == (index % 5)) {
                    printBuzz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        if (n < 1) {
            return;
        }
        while (index <= n && !Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                if (0 == (index % 15)) {
                    printFizzBuzz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        if (n < 1) {
            return;
        }
        while (index <= n && !Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                if (0 != (index % 3) && 0 != (index % 5)) {
                    printNumber.accept(index);
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }
}
