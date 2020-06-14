package study.leetcode.middle.odd;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 *1116. 打印零与奇偶数
 *假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出："0102030405"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZeroEvenOdd {

    private int n;
    private volatile int index = 1;
    private volatile int count = 1;
    private volatile boolean startFlag = true;
    private final Lock lock = new ReentrantLock();
    private final  Condition await = lock.newCondition();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (index <= n && !Thread.currentThread().isInterrupted()){
        lock.lock();
        try {
            if (startFlag){
                printNumber.accept(0);
                count++;
                startFlag = false;
                await.signalAll();
                await.await();
            }
            if (count%2 != 0){
                if (index <= n){
                    printNumber.accept(0);
                }
                count++;
                await.signalAll();
            }else if (index != n ){
                await.await();
            }
            }finally {
                lock.unlock();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (index <= n && !Thread.currentThread().isInterrupted()){
            lock.lock();
            try {
                if (0 == (index%2) && ((count%2) == 0)  && index<=n){
                    printNumber.accept(index++);
                    if (index==n){
                        System.out.println();
                    }
                    count++;
                    await.signalAll();
                }else if (index != n ){
                    await.await();
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (index <= n && !Thread.currentThread().isInterrupted()){
                lock.lock();
                try {
                if (0 != (index%2) && (count%2 == 0) && index<=n){
                    printNumber.accept(index++);
                    if (index==n){
                        System.out.println();
                    }
                    count++;
                    await.signalAll();
                }else if (index != n){
                    await.await();
                }
            }finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            success(i);

        }


    }

    private static void success(int n) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,3,0,TimeUnit.SECONDS,new ArrayBlockingQueue<>(3));
        threadPoolExecutor.submit(()-> {
            for (int i=1; i <= n;i++ ){
                try {
                    zeroEvenOdd.even(ii -> System.out.print(ii));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPoolExecutor.submit(()-> {
            for (int i=1; i <= n;i++ ){
                try {
                    zeroEvenOdd.odd(ii -> System.out.print(ii));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPoolExecutor.submit(()-> {
            for (int i=0; i <= n;i++ ){
                try {
                    zeroEvenOdd.zero(ii -> System.out.print(ii));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPoolExecutor.shutdown();
    }
}
