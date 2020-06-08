package test9;

import test8.Array;
import test8.Stack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class calc extends JFrame implements ActionListener {
    Array ifArray = new Array();
    Array sfArray = new Array();
    Stack nvStack = new Stack();
    Stack opStack = new Stack();
    JButton[] keys = new JButton[18];
    JTextField result = new JTextField(20);
    StringBuilder inputOp;

    calc() {
        JPanel keyJPanel = new JPanel();
        JPanel key = new JPanel();
        keyJPanel.setLayout(new GridLayout(4, 4, 0, 5));
        key.setLayout(new GridLayout(1, 2, 0, 5));
        for (int i = 0; i <= 9; i++) {
            keys[i] = new JButton(String.valueOf(i));
        }
        keys[10] = new JButton("/");
        keys[11] = new JButton("*");
        keys[12] = new JButton("-");
        keys[13] = new JButton("+");
        keys[14] = new JButton("=");
        keys[15] = new JButton(".");
        keys[16] = new JButton("清空");
        keys[17] = new JButton("Del");
        key.add(keys[16]);
        key.add(keys[17]);
        keys[16].addActionListener(this);
        keys[17].addActionListener(this);
        for (int i = 7; i <= 10; i++) {
            keyJPanel.add(keys[i]);
            keys[i].addActionListener(this);
        }
        for (int i = 4; i <= 6; i++) {
            keyJPanel.add(keys[i]);
            keys[i].addActionListener(this);
        }
        keyJPanel.add(keys[11]);
        keys[11].addActionListener(this);
        for (int i = 1; i <= 3; i++) {
            keyJPanel.add(keys[i]);
            keys[i].addActionListener(this);
        }
        keyJPanel.add(keys[12]);
        keys[12].addActionListener(this);
        keyJPanel.add(keys[0]);
        for (int i = 15; i >= 13; i--) {
            keyJPanel.add(keys[i]);
            keys[i].addActionListener(this);
        }
        add(result, BorderLayout.NORTH);
        add(keyJPanel, BorderLayout.CENTER);
        add(key, BorderLayout.SOUTH);
        setTitle("计算器");
        setLocation(100, 100);
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton curr = (JButton) e.getSource();
        if (curr == keys[16]) {
            clearAll();
            refreshResult();
            return;
        }
        if(curr == keys[17]) {
            if(inputOp != null) {
                inputOp.deleteCharAt(inputOp.length() - 1);
            }else {
                ifArray.pop(ifArray.getArraySize() - 1);
            }
            refreshResult();
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (curr == keys[i]) {
                if(inputOp == null) inputOp = new StringBuilder();
                inputOp.append(keys[i].getText().charAt(0));
                refreshResult();
                return;
            }
        }
        if (curr == keys[10]) {
            if(inputOp != null) {
                ifArray.push(Double.parseDouble(inputOp.toString()));
                inputOp = null;
            }
            ifArray.push(keys[10].getText().charAt(0));
            refreshResult();
            return;
        }
        if (curr == keys[11]) {
            if(inputOp != null) {
                ifArray.push(Double.parseDouble(inputOp.toString()));
                inputOp = null;
            }
            ifArray.push(keys[11].getText().charAt(0));
            refreshResult();
            return;
        }
        if (curr == keys[12]) {
            if(inputOp != null) {
                ifArray.push(Double.parseDouble(inputOp.toString()));
                inputOp = null;
            }
            ifArray.push(keys[12].getText().charAt(0));
            refreshResult();
            return;
        }
        if (curr == keys[13]) {
            if(inputOp != null) {
                ifArray.push(Double.parseDouble(inputOp.toString()));
                inputOp = null;
            }
            ifArray.push(keys[13].getText().charAt(0));
            refreshResult();
            return;
        }
        if (curr == keys[14]) {
            if(inputOp != null) {
                ifArray.push(Double.parseDouble(inputOp.toString()));
                inputOp = null;
            }
            stackInitialization();
            Double res = overallCalculation();
            if (isCanInteger(res)) {
                result.setText(String.valueOf(double2int(res)));
            } else {
                result.setText(String.valueOf(res));
            }
            clearAll();
            return;
        }
        if (curr == keys[15]) {
            if(inputOp == null) inputOp = new StringBuilder();
            inputOp.append(keys[15].getText().charAt(0));
            System.out.println(inputOp.toString());
            refreshResult();
        }
    }

    private void stackInitialization() {
        while (!ifArray.isEmpty()) {
            Object obj = ifArray.pop();
            if (obj instanceof Character) {
                char op = (char) obj;
                if (opStack.isEmpty() ||
                        (getPriority((Character) opStack.getStackTop()) < getPriority(
                                op))) {
                    opStack.push(op);
                } else {
                    while (getPriority((Character) opStack.getStackTop()) >= getPriority(
                            op)) {
                        sfArray.push(opStack.pop());
                        if (opStack.isEmpty()) {
                            break;
                        }
                    }
                    opStack.push(op);
                }
            } else if (obj instanceof Double) {
                Double a = (Double) obj;
                sfArray.push(a);
            }
        }
        while (!opStack.isEmpty()) {
            sfArray.push(opStack.pop());
        }
    }

    private Double overallCalculation() {
        while (!sfArray.isEmpty()) {
            if (sfArray.get() instanceof Character) {
                char op = (char) sfArray.pop();
                double p2 = (double) nvStack.pop();
                double p1 = (double) nvStack.pop();
                double res = partialCalculation(p1, p2, op);
                nvStack.push(res);
            } else if (sfArray.get() instanceof Double) {
                nvStack.push(sfArray.pop());
            }
        }
        return (Double) nvStack.getStackTop();
    }

    public double partialCalculation(double p1, double p2, char op) {
        double res = 0;
        switch (op) {
            case '+':
                res = p1 + p2;
                break;
            case '-':
                res = p1 - p2;
                break;
            case '*':
                res = p1 * p2;
                break;
            case '/':
                res = p1 / p2;
                break;
        }
        return res;
    }

    private int getPriority(char ch) {
        int pr;
        switch (ch) {
            case '+':
            case '-':
                pr = 1;
                break;
            case '*':
            case '/':
                pr = 2;
                break;
            default:
                pr = -1;

                break;
        }
        return pr;
    }

    private boolean isCanInteger(Object obj) {
        if (obj instanceof Double) {
            double n1 = (Double) obj;
            int n2 = double2int(n1);
            return n1 - n2 == 0;
        } else {
            return false;
        }
    }

    private int double2int(double n1) {
        return Integer.parseInt(new java.text.DecimalFormat("0").format(n1));
    }

    private void refreshResult() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (ifArray.get(i) != null) {
            if (isCanInteger(ifArray.get(i))) {
                stringBuilder.append(double2int((Double) ifArray.get(i)));
            } else {
                stringBuilder.append(ifArray.get(i));
            }
            i++;
        }
        result.setText(stringBuilder.toString()+((inputOp != null)?inputOp.toString():""));
    }

    private void clearAll() {
        ifArray.clear();
        sfArray.clear();
        opStack.clear();
        nvStack.clear();
    }

    public static void main(String[] args) {
        new calc();
    }
}
