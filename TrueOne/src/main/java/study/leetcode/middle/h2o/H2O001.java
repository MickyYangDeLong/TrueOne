package study.leetcode.middle.h2o;

import java.util.concurrent.Semaphore;

/**
 * @Auther Micky
 * @Date 2020-06-14 20:03
 */
class H2O001 {

    public H2O001() {

    }

    Semaphore semaphore01 = new Semaphore(0);
    Semaphore semaphore02 = new Semaphore(2);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (true) {
            if (semaphore02.tryAcquire()) {
                releaseHydrogen.run();
                semaphore01.release();
            } else {
                Thread.yield();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (true) {
            if (semaphore01.tryAcquire(2)) {

                releaseOxygen.run();
                semaphore02.release(2);
            } else {
                Thread.yield();
            }
        }
    }
}
