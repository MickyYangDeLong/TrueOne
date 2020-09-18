package study.concurrent.automic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther Micky
 * @Date 2020-08-10 23:50
 */
public class CasTest {
    static AtomicInteger atomicInteger = new AtomicInteger();
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0,1);
    static AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<>(1,true);

    public static void main(String[] args) {
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.compareAndSet(0,1,1,2));
        System.out.println(atomicMarkableReference.getReference());
        System.out.println(atomicMarkableReference.compareAndSet(1,3,true,true));
        System.out.println(atomicMarkableReference.compareAndSet(3,3,true,false));

    }
}
