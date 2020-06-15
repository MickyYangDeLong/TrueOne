package study.leetcode.middle.h2o;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther Micky
 * @Date 2020-06-14 20:03
 */
class H2O002 {

    public H2O002() {

    }

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    CyclicBarrier cyclicBarrier1 = new CyclicBarrier(3);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            cyclicBarrier.await();
            cyclicBarrier1.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            cyclicBarrier1.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseOxygen.run();
    }
}
