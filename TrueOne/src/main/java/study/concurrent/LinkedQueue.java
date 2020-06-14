package study.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class LinkedQueue <E>{
    private final Node<E> dummy = new Node<>(null,null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item){
        Node<E> newNode = new Node<>(item, null);
        while (true){
            Node<E> curTail = tail.get();
            Node<E> tailNext = curTail.next.get();
            if (curTail == tail.get()){
                if (null == tailNext){
                    tail.compareAndSet(curTail, tailNext);
                }else{
                    if (curTail.next.compareAndSet(null,newNode)){
                        tail.compareAndSet(curTail,newNode);
                        return true;
                    }
                }
            }
        }
    }

    static class Node<E> {
        public final E item;
        public final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }


    public static void main(String[] args) {
        LinkedQueue<String> concurrentStack = new LinkedQueue<>();
        concurrentStack.put("a");
        concurrentStack.put("b");
        concurrentStack.put("c");
        concurrentStack.put("d");
    }
}
