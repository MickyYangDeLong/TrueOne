package study.algorithm.Tree;

import lombok.Getter;
import lombok.Setter;

//红黑树
public class ReadBlackTree0<K> {


    private static final boolean RED = true;
    private static final boolean BLACK = true;
    private Node<K> root = null;

    public void add(Node node, Integer v) {
        if (root.getValue() < v) {
            if (root.rightChild == null) {
                root.rightChild = new Node<>(v);
            } else {
                add(root.rightChild, v);
            }
        } else {
            if (root.leftChild == null) {
                root.leftChild = new Node<>(v);
            } else {
                add(root.leftChild, v);
            }
        }
    }

    public void leftRotate(Node node){
        if (node.parent == null){
            Node E = root;
            Node S = E.rightChild;

            //移动s的左子树
            E.rightChild = S.getLeftChild();
            S.leftChild.parent = E;

            // 第二步 修改E的指针
            E.parent = S;
            // 第三步修改S的指针
            S.parent = null;
        }else{
            // 如果右父节点，就操作父节点，当前节点，孩子节点三个点
            if(node == node.getParent().leftChild){
                node.parent.leftChild = node.rightChild;
            }else{
                node.parent.rightChild = node.rightChild;
            }
            Node S = node.rightChild;
            node.rightChild = node.rightChild.leftChild;
            S.leftChild.leftChild.parent = node;
            S.leftChild = node;
            S.parent = node.parent;
            node.parent = S;
        }
    }

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
    class Node<K> {//红黑树节点
        private boolean color = RED;
        private K key;
        private int value;
        Node<K> parent;
        Node<K> leftChild;
        Node<K> rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
