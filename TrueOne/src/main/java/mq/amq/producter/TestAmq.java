package mq.amq.producter;

import mq.amq.consumer.Consumer;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestAmq {
    static Executor executor = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        startProduct(new Product());
        startConsumerTopic(new Consumer());
        startConsumerTopic(new Consumer());
        startConsumerQueue(new Consumer());
    }

    private static void startConsumerQueue(final Consumer consumer) {
        System.out.println();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    consumer.consumerQueue();
                } catch (JMSException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println();
    }

    private static void startConsumerTopic(final Consumer consumer) {
        System.out.println();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    consumer.consumerTopic();
                }  catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println();
    }

    private static void startProduct(final Product product) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    product.producerQueue();
                    product.producerTopic();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println();
    }
}
