package test4;

import javax.swing.*;
import java.awt.*;

public class test3 {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("自定义布局");
        jf.setSize(700,700);

        JPanel jp = new JPanel();
        jf.add(jp);

        jp.setLayout(null);
        JButton submitButton = new JButton();
        submitButton.setBounds(50,50,120,30);
        submitButton.setText("提交");
        submitButton.setToolTipText("这是提交信息的按钮！！！");
        jp.add(submitButton);

        JButton backButton = new JButton();
        backButton.setText("返回");
        backButton.setBounds(190,50,120,30);
        backButton.setToolTipText("这是返回主页面的按钮！！！");
        jp.add(backButton);

        JLabel divLabel = new JLabel();
        divLabel.setText("爱笑的祥和");
        divLabel.setOpaque(true);//设置背景为非透明
        divLabel.setBounds(50,100,120,30);
        divLabel.setBackground(Color.CYAN);
        divLabel.setFont(new Font("楷体", 1,15));//字体名，加粗（1），字体大小
        jp.add(divLabel);

        JLabel mobileLabel = new JLabel();
        mobileLabel.setBounds(50,150, 80,30);
        mobileLabel.setText("电话号码：");
        jp.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(150,150,200,30);
        jp.add(mobileField);

        JTextArea jt = new JTextArea();
        jt.setBounds(50,210,200,160);
        jt.setLineWrap(true);
        jp.add(jt);

        jf.setVisible(true);
    }
}
