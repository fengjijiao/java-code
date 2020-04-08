public class MyClass {
    public static void main(String args[]) {
        A2 a2 = new A2();
        B2 b2 = new B2();
        a2.showa();
        b2.showb();
    }
    /*
    *使用内部类来解决java不能多重继承的问题
    */
    static class A2 extends A {
        @Override
        void showa() {
            System.out.println("这是A2类!");
        }
    }
    static class B2 extends B {
        @Override
        void showb() {
            System.out.println("这是B2类!");
        }
    }
}
class A {
    void showa() {
        System.out.println("这是A类!");
    }
}

class B {
    void showb() {
        System.out.println("这是B类!");
    }
}
