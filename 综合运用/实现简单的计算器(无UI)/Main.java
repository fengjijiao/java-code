package test8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Array ifArray, sfArray;
    private static Stack opStack, nvStack;
    public static void main(String[] args) {
        ifArray = new Array();
        sfArray = new Array();
        opStack = new Stack();
        nvStack = new Stack();
        Scanner scanner = new Scanner(System.in);
        String last;
        while (scanner.hasNext()) {
            last = scanner.next();
            if(last.equals("=")) break;
            if(isNumeric(last)) {
                ifArray.push(Double.parseDouble(last));
            }else {
                ifArray.push(last);
            }
        }
        stackInitialization();
        double result = overallCalculation();
        System.out.println("计算结果：" + result);
    }

    private static void stackInitialization() {
        while (!ifArray.isEmpty()) {
            Object obj = ifArray.pop();
            if(obj instanceof String) {
                String a = (String) obj;
                char op = a.charAt(0);
                if(op == '(') {
                    opStack.push(op);
                }else if(op == ')') {
                    while ((Character) opStack.getStackTop() != '(') {
                        char newOp = (char) opStack.pop();
                        sfArray.push(newOp);
                    }
                    if((Character) opStack.getStackTop() == '(') {
                        opStack.pop();
                    }
                }else if(opStack.isEmpty() || getPriority((Character) opStack.getStackTop()) < getPriority(op)) {
                    opStack.push(op);
                }else {
                    while (getPriority((Character) opStack.getStackTop()) >= getPriority(op)) {
                        sfArray.push(opStack.pop());
                        if(opStack.isEmpty()) break;
                    }
                    opStack.push(op);
                }
            }else if(obj instanceof Double) {
                Double a = (Double) obj;
                sfArray.push(a);
            }
        }
        while (!opStack.isEmpty()) {
            sfArray.push(opStack.pop());
        }
    }

    private static Double overallCalculation() {
        while (!sfArray.isEmpty()) {
            if(sfArray.get() instanceof Character) {
                char op = (char) sfArray.pop();
                double p2 = (double) nvStack.pop();
                double p1 = (double) nvStack.pop();
                double res = partialCalculation(p1,p2,op);
                nvStack.push(res);
            }else if(sfArray.get() instanceof Double) {
                nvStack.push(sfArray.pop());
            }
        }
        return (Double) nvStack.getStackTop();
    }

    public static double partialCalculation(double p1,double p2, char op) {
        double res = 0;
        switch (op) {
            case '+':
                res = p1+p2;
                break;
            case '-':
                res = p1-p2;
                break;
            case '*':
                res = p1*p2;
                break;
            case '/':
                res = p1/p2;
                break;
        }
        return res;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9.]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    private static int getPriority(char ch) {
        int pr;
        switch (ch) {
            case '(':
                pr = 0;
                break;
            case ')':
                pr = 3;
                break;
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
}
