package test4;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
public class test4 extends JFrame {
    private static test4 mInstance;
    private static JPanel drawingBoard;
    private static String[] buttonTexts = {"线条","矩形","文字","椭圆类"};
    private static String actionType = buttonTexts[0];
    private static ActionListener actionListener;

    test4() {
        setSize(800,500);
        JPanel CPPanel = new JPanel();
        add(CPPanel,BorderLayout.NORTH);

        actionListener = new MyActionEvent();
        for(String text: buttonTexts) {
            JButton jActionButton=new JButton(text);
            jActionButton.addActionListener(actionListener);
            CPPanel.add(jActionButton);
        }

        drawingBoard = new MyJPanel();
        add(drawingBoard);

        setVisible(true);
    }

    public static void main(String[] args) {
        mInstance = new test4();
    }

    public static String getActionType() {
        return actionType;
    }

    public static void setActionType(String actionType) {
        test4.actionType = actionType;
    }
}

class XYCoordinate {
    private int X;
    private int Y;

    public XYCoordinate() {
        this(0,0);
    }

    public XYCoordinate(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public XYCoordinate setX(int x) {
        X = x;
        return this;
    }

    public int getY() {
        return Y;
    }

    public XYCoordinate setY(int y) {
        Y = y;
        return this;
    }
}

class MyJPanel extends JPanel {
    MyJPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MyMouseEvent(this));
    }
}

class MyActionEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        if(actionCommand.equals("线条")
                ||actionCommand.equals("矩形")
                ||actionCommand.equals("文字")
                ||actionCommand.equals("椭圆类")) {
            test4.setActionType(actionCommand);
        }
    }
}

class MyMouseEvent implements MouseListener {
    private MyJPanel myJPanel;
    private Color penColor = Color.BLUE;
    public XYCoordinate
            pressedXYCoordinate = new XYCoordinate(), enteredXYCoordinate = new XYCoordinate(),
            clickedXYCoordinate = new XYCoordinate(), releasedXYCoordinate = new XYCoordinate(),
            exitedXYCoordinate = new XYCoordinate();

    public MyMouseEvent(MyJPanel myJPanel) {
        this.myJPanel = myJPanel;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println(String.format("mouseClicked:x --> %s, y --> %s", e.getX(), e.getY()));
        clickedXYCoordinate.setX(e.getX()).setY(e.getY());
        Graphics graphics = myJPanel.getGraphics();
        graphics.setColor(penColor);
        if(test4.getActionType().equals("文字")) {
            graphics.drawString("爱笑的祥和是**",clickedXYCoordinate.getX(),clickedXYCoordinate.getY());
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        System.out.println(String.format("mousePressed:x --> %s, y --> %s", e.getX(), e.getY()));
        pressedXYCoordinate.setX(e.getX()).setY(e.getY());
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        System.out.println(String.format("mouseReleased:x --> %s, y --> %s", e.getX(), e.getY()));
        releasedXYCoordinate.setX(e.getX()).setY(e.getY());
        Graphics graphics = myJPanel.getGraphics();
        graphics.setColor(penColor);
        if(test4.getActionType().equals("线条")) {
            graphics.drawLine(pressedXYCoordinate.getX(),pressedXYCoordinate.getY(),releasedXYCoordinate.getX(),releasedXYCoordinate.getY());
        }else if(test4.getActionType().equals("矩形")) {
            graphics.drawRect(pressedXYCoordinate.getX(),pressedXYCoordinate.getY(),releasedXYCoordinate.getX()-pressedXYCoordinate.getX(),releasedXYCoordinate.getY()-pressedXYCoordinate.getY());
        }else if(test4.getActionType().equals("椭圆类")) {
            graphics.drawOval(pressedXYCoordinate.getX(),pressedXYCoordinate.getY(),releasedXYCoordinate.getX()-pressedXYCoordinate.getX(),releasedXYCoordinate.getY()-pressedXYCoordinate.getY());
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        System.out.println(String.format("mouseEntered:x --> %s, y --> %s", e.getX(), e.getY()));
        enteredXYCoordinate.setX(e.getX()).setY(e.getY());
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        System.out.println(String.format("mouseExited:x --> %s, y --> %s", e.getX(), e.getY()));
        exitedXYCoordinate.setX(e.getX()).setY(e.getY());
    }

    public Color getPenColor() {
        return penColor;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }
}