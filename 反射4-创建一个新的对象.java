//test5.java
package test2;

import java.lang.reflect.Constructor;

public class test5 {
    public static void main(String[] args) {
        try {
            Class cla = Class.forName("test2.CPTest");
            //默认,无参构造函数
            Constructor con = cla.getConstructor();
            Object obj = con.newInstance();
            CPTest cpTest = (CPTest) obj;
            System.out.println(cpTest.name + "," + cpTest.age);
            //public构造函数
            Constructor con1 = cla.getConstructor(String.class);
            Object obj1 = con1.newInstance("张三");
            CPTest cpTest1 = (CPTest) obj1;
            System.out.println(cpTest1.name + "," + cpTest1.age);
            //private构造方法(强制创建)
            Constructor con2 = cla.getDeclaredConstructor(String.class, int.class);
            //java.lang.IllegalAccessException: class test2.test5 cannot access a member of class test2.CPTest with modifiers "private"
            con2.setAccessible(true);//去除private修饰符;重要的，否则会报上面的错误
            Object obj2 = con2.newInstance("张三", 13);
            CPTest cpTest2 = (CPTest) obj2;
            System.out.println(cpTest2.name + "," + cpTest2.age);
            /*
            李四,23
            张三,23
            张三,13
             */
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
//CPTest.java
package test2;

public class CPTest extends CTest implements Study, Move {
    String name = "李四";
    int age = 23;

    public CPTest() {
    }

    public CPTest(String name) {
        this.name = name;
    }

    private CPTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void MoveType() {
        System.out.println("骑自行车");
    }

    @Override
    public void StudyWhat() {
        System.out.println("高中知识");
    }
}
//CTest
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
//Study.java
package test2;

public interface Study {
    void StudyWhat();
}
//Move.java
package test2;

public interface Move {
    void MoveType();
}
