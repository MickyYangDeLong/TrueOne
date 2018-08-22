package o.two;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 * @author CCQ
 * @Description
 * @date 2017年6月23日 下午6:24:06
 */

public class Yard extends Frame {
    private static final long serialVersionUID = 1L;
    public static final int ROWS = 30;        //定义行数
    public static final int COLS = 30;        //定义列数
    public static final int BLOCK_SIZE = 15;
    private Font fontGameOver = new Font("宋体", Font.BOLD, 50);
    private int score = 0;                     //计算获得分数
    private volatile boolean gameOver = false;         //是否死亡

    Snake s = new Snake(this);
    Egg e = new Egg();
    Image offScreenImage = null;
    PaintThread paintThread = new PaintThread();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 生成一个窗口
     */
    public void launch() {
        this.setLocation(450, 150);
        this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               // System.exit(0);
            }
        });
        this.setVisible(true);
        this.addKeyListener(new KeyMonitor());
        // new Thread(paintThread).start();
        paintThread.run();
    }

    //解决窗口闪烁
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        }
        Graphics goff = offScreenImage.getGraphics();
        paint(goff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    //停止
    public void stop() {
        this.gameOver = true;
    }

    //画出方格
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        g.setColor(Color.DARK_GRAY);
        // 画出横线
        for (int i = 3; i <= ROWS - 1; i++) {
            g.drawLine(BLOCK_SIZE, BLOCK_SIZE * i, (COLS - 1) * BLOCK_SIZE, BLOCK_SIZE * i);
        }
        // 画竖线
        for (int j = 1; j <= COLS - 1; j++) {
            g.drawLine(BLOCK_SIZE * j, BLOCK_SIZE * 3, BLOCK_SIZE * j, (ROWS - 1) * BLOCK_SIZE);
        }
        g.setColor(Color.YELLOW);
        g.drawString("分数:" + score + "  按space可以重新开始", 10, 40);
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(fontGameOver);
            g.drawString("GAME OVER", 85, 225);
            paintThread.pause();
        }
        g.setColor(c);
        s.eat(e);
        e.drow(g);
        s.drow(g);
    }

    private class PaintThread implements Runnable {
        private volatile boolean pause = false;
        private volatile boolean running = true;

        @Override
        public void run() {
            while (true) {
                while (running) {
                    try {
                        if (pause)
                            continue;
                        else
                            repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void pause() {
            this.pause = true;
            this.running = false;
        }

        public void reStart() {
            gameOver = false;
            this.pause = false;
            this.running = true;
           // startGame();
        }
    }

    //绑定键盘事件
    private class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (Objects.equals(e.getKeyCode(), KeyEvent.VK_SPACE)) {
                s.init();
                paintThread.reStart();
            }
            s.keyPressed(e);
        }
    }

    /**
     * 开始
     */
    public static void main(String[] args) {
        startGame();
    }

    static final Yard yard = new Yard();

    private static void startGame() {
        yard.launch();
    }
}
