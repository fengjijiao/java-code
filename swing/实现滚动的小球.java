package test5;

import javax.swing.*;
import java.awt.*;

public class test4 {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(850,550);
        BallEff be = new BallEff();
        jf.add(be);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        be.draw();
    }
}

class BallEff extends JPanel {
    private int count = 0,ballSize;
    private Point location;
    public BallEff() {
        setBackground(Color.WHITE);
        setBounds(800,500,30,30);
    }

    public void draw() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始");
                for(int i=0;i<90;i++) {
                    Graphics graphics = getGraphics();
                    graphics.setColor(Color.BLACK);
                    graphics.drawLine(0,340, 850, 340);
                    graphics.setColor(Color.WHITE);
                    if(count > 0) {
                        graphics.fillRect(location.x, location.y, ballSize, ballSize);
                    }
                    refreshL();
                    graphics.setColor(Color.PINK);
                    graphics.fillRoundRect(location.x,location.y,ballSize,ballSize,ballSize,ballSize);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("结束");
            }
        }).start();

    }

    private void refreshL() {
        if(location == null) location = new Point();
        if(count > 0) {
            location.x += 5;
            location.y -= 5;
            ballSize += 5;
        }else {
            location.x = 0;
            location.y = 320;
            ballSize = 20;
        }
        count++;
    }
}
