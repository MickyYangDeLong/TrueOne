package study.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 非阻塞的栈 271页 <java并发编程实践>
 */
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> top = new AtomicReference<>();
    public void push(E item){
        Node<E> newHead = new Node<>(item);
        Node<E> oldHead = top.get();
        newHead.next = oldHead;
        while(!top.compareAndSet(oldHead, newHead)){
            oldHead = top.get();
            newHead.next = oldHead;
        }
    }

    public E pop(){
        Node<E> oldHead;
        Node<E> newHead;
        do{
            oldHead = top.get();
            if (null == oldHead){
                return null;
            }
            newHead = oldHead.next;
        }while(!top.compareAndSet(oldHead, newHead));
        return oldHead.item;

    }

    static class Node<E> {
        public final E item;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        ConcurrentStack<String> concurrentStack = new ConcurrentStack<>();
        concurrentStack.push("a");
        concurrentStack.push("b");
        concurrentStack.push("c");
        concurrentStack.push("d");
        System.out.println(concurrentStack.pop());
        System.out.println(concurrentStack.pop());
        System.out.println(concurrentStack.pop());
        System.out.println(concurrentStack.pop());
        System.out.println(concurrentStack.pop());
    }

}
