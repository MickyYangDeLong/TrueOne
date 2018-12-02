package servlet;

import java.util.*;
import java.util.concurrent.*;

public class Test {
    private final static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        ScheduledExecutorService product = Executors.newScheduledThreadPool(2);
        Random random = new Random();
        product.scheduleAtFixedRate(() -> {
            try {
                blockingQueue.offer(random.nextInt(101));  //offer()方法就是网队列的尾部设置值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);  //每200毫秒执行线程

        product.scheduleAtFixedRate(() -> {
            System.out.println("开始取值");
            List<Integer> list = new LinkedList<>();
            blockingQueue.drainTo(list);  //drainTo()将队列中的值全部从队列中移除，并赋值给对应集合
            System.out.println(list);
        }, 2000, 2000, TimeUnit.MILLISECONDS);
    }
}

