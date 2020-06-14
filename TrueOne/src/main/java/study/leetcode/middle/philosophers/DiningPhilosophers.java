package study.leetcode.middle.philosophers;

import java.util.concurrent.Semaphore;

/**
 * @Auther Micky
 * @Date 2020-06-13 19:49
 * 1226. 哲学家进餐
 * 5 个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5 个哲学家，5 根叉子）
 * <p>
 * 所有的哲学家都只会在思考和进餐两种行为间交替。哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。
 * <p>
 * 假设面的数量没有限制，哲学家也能随便吃，不需要考虑吃不吃得下。
 * <p>
 * 设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。
 */
public class DiningPhilosophers {
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        synchronized (this) {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }

    private static final int EAT_TIMES = 2;
    private static final int PHILOSOPHERS_NUMBERS = 6;

    public static void main(String[] args) throws InterruptedException {
        System.out.print("[");
        Semaphore semaphore = new Semaphore(0);
        Semaphore semaphoreStart = new Semaphore(0);
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        for (int i = 0; i < PHILOSOPHERS_NUMBERS; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    semaphoreStart.acquire();
                    for (int k = 0; k < EAT_TIMES; k++) {

                        diningPhilosophers.wantsToEat(index,
                                () -> {
                                    System.out.print("[" + index + ",1,1]");
                                },
                                () -> {
                                    System.out.print("[" + index + ",1,2]");
                                },
                                () -> {
                                    System.out.print("[" + index + ",0,3]");
                                },
                                () -> {
                                    System.out.print("[" + index + ",2,1]");
                                },
                                () -> {
                                    System.out.print("[" + index + ",2,2]");
                                });
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        semaphoreStart.release(PHILOSOPHERS_NUMBERS);
        semaphore.acquire(PHILOSOPHERS_NUMBERS);
        System.out.print("]");
    }
}
