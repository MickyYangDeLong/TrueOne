package study.leetcode.middle.h2o;

import java.util.concurrent.Semaphore;

/**
 * @Auther Micky
 * @Date 2020-06-14 20:03
 */
class H2O06 {

    public H2O06() {

    }


    aqs

    Semaphore semaphore01 = new Semaphore(0);
    Semaphore semaphore02 = new Semaphore(2);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphore02.acquire();
        releaseHydrogen.run();
        semaphore01.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphore01.acquire(2);
        releaseOxygen.run();
        semaphore02.release(2);
    }
}
