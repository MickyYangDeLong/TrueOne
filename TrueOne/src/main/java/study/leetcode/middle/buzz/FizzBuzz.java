package study.leetcode.middle.buzz;

import java.util.function.IntConsumer;
//### 解题思路 1195. 交替打印字符串
/**
 *
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
//交替打印的话，一定涉及等待和通知，可以用Synchronized或者Lock等实现，如果用cas"死循环"感觉会很耗内存。
class FizzBuzz {
    private int n;
    private volatile int index=1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        if(n<1){
            return;
        }
        while(index<=n && !Thread.currentThread().isInterrupted()){
            synchronized(this){
                if(0 != (index%5) && 0 == (index%3)){
                    printFizz.run();
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }


    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        if(n<1){
            return;
        }
        while(index<=n && !Thread.currentThread().isInterrupted()){
            synchronized(this){
                if(0 != (index%3) && 0 == (index%5)){
                    printBuzz.run();
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        if(n<1){
            return;
        }
        while(index<=n && !Thread.currentThread().isInterrupted()){
            synchronized(this){
                if(0 == (index%15)){
                    printFizzBuzz.run();
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        if(n<1){
            return;
        }
        while(index<=n && !Thread.currentThread().isInterrupted()){
            synchronized(this){
                if(0 != (index%3) && 0 != (index%5)){
                    printNumber.accept(index);
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }
}
