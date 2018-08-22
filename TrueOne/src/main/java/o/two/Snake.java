package o.two;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

public class Snake {
    private Node head = null;  //蛇头
    private Node tail = null;  //蛇尾
    private int size = 0;      //蛇长度
    private Node n = new Node(20, 20, Dir.L); //初始化蛇的位子
    private Yard y;

    public Snake(Yard y) {
        head = n;
        tail = n;
        size = 1;
        this.y = y;
    }

   public void  init(){
       head = tail = new Node(20, 20, Dir.L); //初始化蛇的位子
       size = 1;
    }

    /**
     * 加一段在尾巴上
     */
    public void addToTail() {
        Node node = null;
        switch (tail.dir) {
            case L:
                node = new Node(tail.row, tail.col + 1, tail.dir);
                break;
            case U:
                node = new Node(tail.row + 1, tail.col, tail.dir);
                break;
            case R:
                node = new Node(tail.row, tail.col - 1, tail.dir);
                break;
            case D:
                node = new Node(tail.row - 1, tail.col, tail.dir);
                break;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    /**
     * 加一段在头上
     */
    public void addHead() {
        Node node = null;
        switch (head.dir) {
            case L:
                node = new Node(head.row, head.col - 1, head.dir);
                break;
            case U:
                node = new Node(head.row - 1, head.col, head.dir);
                break;
            case R:
                node = new Node(head.row, head.col + 1, head.dir);
                break;
            case D:
                node = new Node(head.row + 1, head.col, head.dir);
                break;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    //画出一条蛇
    public void drow(Graphics g) {
        if (size <= 0) {
            return;
        }
        move();
        for (Node n = head; n != null; n = n.next) {
            n.drow(g);
        }
    }

    //蛇移动
    public void move() {
        addHead();
        deleteFromTail();
        checkDead();
    }


    //检查是否碰撞

    public void checkDead() {
        if (head.row < 3 || head.col < 1 || head.row > Yard.ROWS - 2 || head.col > Yard.COLS - 2) {
            y.stop();
        }

        for (Node n = head.next; n != null; n = n.next) {
            if (head.row == n.row && head.col == n.col) {
                y.stop();
            }
        }
    }

    //删出蛇尾
    public void deleteFromTail() {
        if (size == 0)
            return;
        tail = tail.prev;
        tail.next = null;
    }

    //定义一个内部类，实现蛇的生成，双向链表
    private class Node {
        int w = Yard.BLOCK_SIZE;
        int h = Yard.BLOCK_SIZE;
        int row, col;
        Dir dir = Dir.L;
        Node next = null;      //链表，后一个指针
        Node prev = null;      //链表，前一个指针

        public Node(int row, int col, Dir dir) {
            super();
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        void drow(Graphics g) {
            Color c = g.getColor();
            g.setColor(Color.BLACK);
            g.fillRect(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, w, h);
            g.setColor(c);
        }
    }

    //吃食物
    public void eat(Egg e) {
        if (this.getRect().intersects(e.getRect())) {
            boolean isSuccess = false;
            while (!isSuccess) {
                Map<String, Integer> map = e.reAppear();
                for (Node n = head; n != null; n = n.next) {
                    if (n.row != map.get("row") || n.col != map.get("col")) {
                        isSuccess = true;
                    }
                }
            }
            this.addToTail();
            y.setScore(y.getScore() + 5);
        }
    }

    public Rectangle getRect() {
        return new Rectangle(Yard.BLOCK_SIZE * head.col, Yard.BLOCK_SIZE * head.row, head.w, head.h);
    }

    // 键盘事件，控制蛇的方向
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                if (head.dir != Dir.R)
                    head.dir = Dir.L;
                break;
            case KeyEvent.VK_UP:
                if (head.dir != Dir.D)
                    head.dir = Dir.U;
                break;
            case KeyEvent.VK_RIGHT:
                if (head.dir != Dir.L)
                    head.dir = Dir.R;
                break;
            case KeyEvent.VK_DOWN:
                if (head.dir != Dir.U)
                    head.dir = Dir.D;
                break;
        }
    }
}