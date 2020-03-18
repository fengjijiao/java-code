import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Fr fr=new Fr();
        System.out.println("fr.getA():"+fr.getA());
        System.out.println("fr.getB():"+fr.getB());
        //System.out.println("fr.getC():"+fr.getC());//getC()' has private access in 'Fr'
        System.out.println("fr.getD():"+fr.getD());
        De de=new De();
        System.out.println("de.getA():"+de.getA());
        System.out.println("de.getB():"+de.getB());
        //System.out.println("de.getC():"+de.getC());//getC()' has private access in 'Fr'
        System.out.println("de.getD():"+de.getD());
    }
}
class De extends Fr {
    protected int getA() {
        return 33;
    }
}
class Fr {
    private static int a=66;
    private static int b=63;
    private static int c=69;
    private static int d=39;
    protected int getA() {
        return a;
    }
    int getB() {
        return b;
    }
    private int getC() {
        return c;
    }
    public int getD() {
        return d;
    }
}