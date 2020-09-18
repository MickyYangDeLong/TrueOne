package study.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadLocal {
    static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(5, 5, 60,
            TimeUnit.SECONDS, new LinkedTransferQueue<>(), new MyThreadFactory(),
            (r, e) -> System.out.println("Task " + r.toString() + " rejected from " + e.toString()));

    final static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    static CountDownLatch countDownLatchEnd = new CountDownLatch(6);
    static CountDownLatch countDownLatchStart = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(getThreadName());
        System.out.println("==========================");
        Future<String> future = EXECUTOR_SERVICE.submit(() -> {
            countDownLatchStart.await();
            THREAD_LOCAL.set("tread001");
            countDownLatchEnd.countDown();
            return getValue();
        });
        Future<String> future2 = EXECUTOR_SERVICE.submit(() -> {
            countDownLatchStart.await();
            THREAD_LOCAL.set("tread002");
            countDownLatchEnd.countDown();
            return getValue();
        });
        Future<String> future3 = EXECUTOR_SERVICE.submit(() -> {
            countDownLatchStart.await();
            THREAD_LOCAL.set("tread003");
            countDownLatchEnd.countDown();
            return getValue();
        });
        Future<String> future4 = EXECUTOR_SERVICE.submit(() -> {
            countDownLatchStart.await();
            THREAD_LOCAL.set("tread004");
            countDownLatchEnd.countDown();
            return getValue();
        });
        Future<String> future5 = EXECUTOR_SERVICE.submit(() -> {
            countDownLatchStart.await();
            THREAD_LOCAL.set("tread005");
            countDownLatchEnd.countDown();
            return getValue();
        });
        Future<String> future6 = EXECUTOR_SERVICE.submit(() -> {
            countDownLatchStart.await();
            THREAD_LOCAL.set("tread006");
            countDownLatchEnd.countDown();
            return getValue();
        });
        System.out.println("All workers start!");
       countDownLatchStart.countDown();
        countDownLatchEnd.await();
        System.out.println(future.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println(future4.get());
        System.out.println(future5.get());
        System.out.println(future6.get());

        System.out.println("All workers down!");
        EXECUTOR_SERVICE.shutdown();
    }

    private static String getValue() {
        return getThreadName()+" "+THREAD_LOCAL.get();
    }

    public static String getThreadName() {
        return Thread.currentThread().toString();
    }


    private static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "MyThreadFactory-Test-pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

}