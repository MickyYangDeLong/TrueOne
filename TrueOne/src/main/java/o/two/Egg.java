package o.two;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author CCQ
 * @Description 生成食物
 * @date 2017年6月23日 上午9:23:59
 */

public class Egg {
    int row, col;
    int w = Yard.BLOCK_SIZE;
    int h = Yard.BLOCK_SIZE;
    private static Random r = new Random();

    public Egg(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    public Egg() {
        this(r.nextInt(Yard.ROWS - 5) + 3, r.nextInt(Yard.COLS - 3) + 2);
    }

    //重新设计生成食物
    public Map<String, Integer> reAppear() {
        this.row = r.nextInt(Yard.ROWS - 5) + 3;
        this.col = r.nextInt(Yard.COLS - 3) + 2;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("row", this.row);
        map.put("col", this.col);
        return map;
    }

    public Rectangle getRect() {
        return new Rectangle(Yard.BLOCK_SIZE * this.col, Yard.BLOCK_SIZE * this.row, this.w, this.h);
    }

    //画出食物
    public void drow(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillOval(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, w, h);
        g.setColor(c);
    }
}