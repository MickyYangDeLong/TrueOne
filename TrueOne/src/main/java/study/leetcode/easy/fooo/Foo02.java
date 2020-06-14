package study.leetcode.easy.fooo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Auther Micky
 * @Date 2020-06-14 11:51
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Foo02 {

    public Foo02() {

    }

    final CountDownLatch countDownLatch = new CountDownLatch(1);
    final CountDownLatch countDownLatch1 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch.await();
        printSecond.run();
        countDownLatch1.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch1.await();
        printThird.run();
    }

    public static void main(String[] args) {
        for (int i = 0; i< 5 ; i++){
            test();
        }

    }

    private static void test() {
        Foo02 foo = new Foo02();
        new Thread(()->{
            try {
                foo.first(()-> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(()-> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.third(()-> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
