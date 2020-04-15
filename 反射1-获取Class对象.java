//test.class
package test2;

public class test {
    /**
     * 获取一个类的Class实例对象(4种方法)
     * @param args
     */
    public static void main(String[] args) {
        //1.通过实例获取
        CTest ctest = new CTest();
        Class a = ctest.getClass();
        //2.直接通过class类
        Class a1 = CTest.class;
        //3.通过包名+类名
        try {
            Class a2 = Class.forName("test2.CTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //4.通过classloader
        try {
            Class a3 = ctest.getClass().getClassLoader().loadClass("test2.CTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//CTest.class
package test2;

public class CTest {
    int a = 9;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
