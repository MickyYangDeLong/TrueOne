package study.algorithm.Tree;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//红黑树
public class TwoSortTree<K,V> {


    private static final boolean READ = true;
    private static final boolean BLACK = true;
    private Node<K,V> root = null;

    /*public Node<K,V> add(K k,V v){


    }

    public Node<K,V> getByKey(K k){

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
    class Node<K,V>{//红黑树节点
        private boolean color;
        private K key;
        private V value;
        Node<K,V> parent;
        Node<K,V> leftChild;
        Node<K,V> rightChild;
    }
}
