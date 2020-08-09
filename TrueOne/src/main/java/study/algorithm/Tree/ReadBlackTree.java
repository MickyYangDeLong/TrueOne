package study.algorithm.Tree;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

//红黑树
public class ReadBlackTree <K,V> {


    private static final boolean RED = true;
    private static final boolean BLACK = true;
   /* private Node<K,V extent> root = null;

    public Node<K,V> add(Node node,V v){
        if (root.getValue(). v)

    }*/

   /* public Node<K,V> getByKey(K k){

    }

    public List<Node<K,V>> preOrderTraverse(K k){

    }

    public List<Node<K,V>> middleOrderTraverse(K k){

    }

    public List<Node<K,V>> afterOrderTraverse(K k){

    }

    public List<Node<K,V>> leverOrderTraverse(K k){

    }

    public int size(){

    }

    public int high(){

    }*/


    @Getter
    @Setter
    class Node<K,V extends Comparator>{//红黑树节点
        private boolean color = RED;
        private K key;
        private V value;
        Node<K,V> parent;
        Node<K,V> leftChild;
        Node<K,V> rightChild;
    }
}
