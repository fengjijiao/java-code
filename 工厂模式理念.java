public class MyClass {
    public static void main(String args[]) {
      BMW bmw3 = new BMW3Factory().product();
      bmw3.showInfo();
    }
}
/*
*通过一层一层的封装，免去改变一行代码而导致的多处修改
*/
interface BMW {
    void showInfo();
}
class BMW3 implements BMW {
    public void showInfo() {
        System.out.println("这是一辆BMW3！");
    }
}
interface BMWFactory {
    BMW product();
}
class BMW3Factory implements BMWFactory {
    public BMW3 product() {
        System.out.println("生产一辆BMW3完成！");
        return new BMW3();
    }
}
