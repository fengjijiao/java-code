package test4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {
    FlowLayout flowLayout = new FlowLayout();
    JButton a = new JButton("hello");
    JButton b = new JButton("world");
    JLabel jLabel = new JLabel();
    test() {
        setTitle("hello world!");
        setSize(600,600);
        setLayout(new FlowLayout());//==getContentPane() & addLayout
        Container container = getContentPane();
        container.add(a);
        container.add(b);
        container.add(jLabel);
        a.addActionListener(this);
        b.addActionListener(this);
        setLocation(100,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new test();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (a.equals(e.getSource())) {
            updateJlabe("你点击了hello");
            JDialog jDialog = new JDialog();
            //jDialog.
        }
    }

    private void updateJlabe(String text) {
        String sourceText = jLabel.getText();
        jLabel.setText(sourceText + "\n" + text);
    }
}
