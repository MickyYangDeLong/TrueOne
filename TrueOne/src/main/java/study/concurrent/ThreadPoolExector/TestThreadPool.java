package study.concurrent.ThreadPoolExector;

import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

public class TestThreadPool {

    @Test
    public void TestThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1, 500, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2048));
        Future<String> future = threadPoolExecutor.submit(() -> "aaa");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
