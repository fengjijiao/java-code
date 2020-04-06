public class MyClass {
    public static void main(String args[]) {
      int x=10;
      int y=25;
      int z=x+y;
      A a=new A();
      B b=new B();
      C c=new C();
      System.out.println(a instanceof A);
      System.out.println(a instanceof B);
      System.out.println(a instanceof C);//报错
      System.out.println(a instanceof Object);
    }
    static class C extends B {
        int c=1;
    }
    static class A extends B {
        int a=0;
    }
    static class B {
        int b=2;
    }
}
