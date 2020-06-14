package study.leetcode.easy.fooo;

import java.util.concurrent.atomic.AtomicInteger;

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
class Foo05 {

    public Foo05() {

    }

    private volatile int atomicInteger = 0;

    public void first(Runnable printFirst)   {
        printFirst.run();
        atomicInteger =1;
    }

    public void second(Runnable printSecond)  {
        while (atomicInteger < 1) {
            Thread.yield();
        }
        printSecond.run();
        atomicInteger = 2;
    }

    public void third(Runnable printThird)   {
        while (atomicInteger < 2) {
            Thread.yield();
        }
        printThird.run();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            test();
        }

    }

    private static void test() {
        Foo05 foo = new Foo05();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
