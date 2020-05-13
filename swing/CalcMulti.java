package test4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcMulti {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("爱笑的祥和是**");
        jf.setSize(700,400);
        JPanel jp = new JPanel();
        jf.add(jp);
        addCalcPanel(jp);
        jf.setVisible(true);
    }
    public static void addCalcPanel(JPanel jp) {
        jp.setLayout(null);//importance

        JLabel firstFactorLabel = new JLabel();
        firstFactorLabel.setText("第一个数：");
        firstFactorLabel.setBounds(50,50, 120, 50);
        jp.add(firstFactorLabel);

        JTextField firstFactorField = new JTextField();
        firstFactorField.setBounds(190,50,200,50);
        jp.add(firstFactorField);

        JLabel secondFactorLabel = new JLabel();
        secondFactorLabel.setText("第二个数：");
        secondFactorLabel.setBounds(50,120, 120, 50);
        jp.add(secondFactorLabel);

        JTextField secondFactorField = new JTextField();
        secondFactorField.setBounds(190,120,200,50);
        jp.add(secondFactorField);

        JButton calcButton = new JButton();
        calcButton.setText("计算积");
        calcButton.setBounds(170,190,200,50);
        jp.add(calcButton);

        JTextField resultField = new JTextField();
        resultField.setBounds(80,260,300,50);
        jp.add(resultField);

        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstFactor = Integer.parseInt(firstFactorField.getText());
                int secondFactor = Integer.parseInt(secondFactorField.getText());
                resultField.setText(String.valueOf(firstFactor*secondFactor));
            }
        });
    }
}
