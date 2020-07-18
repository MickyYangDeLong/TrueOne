package study.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther Micky
 * @Date 2020-07-14 23:06
 */
public class ExchangerTest {
    private static final Exchanger<String> EXCHANGER = new Exchanger<>();
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(()->{
            try {
                String A = "bank water A";
                String B = EXCHANGER.exchange(A);
                System.out.println(A.equals(B));
                System.out.println("AAAA A is "+A);
                System.out.println("AAAA B is "+B);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                String B = "bank water B";
                String A = EXCHANGER.exchange(B);
                System.out.println(A.equals(B));
                System.out.println("BBBB A is "+A);
                System.out.println("BBBB B is "+B);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        executorService.shutdown();


    }


}
