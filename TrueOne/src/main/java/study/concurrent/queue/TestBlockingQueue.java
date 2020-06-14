package study.concurrent.queue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBlockingQueue {
    @Test
    public void TestArrayBlockingQueue(){
        //有界队列，不支持扩容
        //ArrayList 1.5 * oldList 扩容
        //Map Set 2 * oldList 扩容
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1024);

    }
}
