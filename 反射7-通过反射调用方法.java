package test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//通过反射调用方法
public class test8 {
    public static void main(String[] args) {
        try {
            Class cla = Class. forName("test2.CPTest");
            Constructor con = cla.getConstructor();
            Object obj = con.newInstance();
            CPTest cpTest = (CPTest) obj;
            //通过类的方式
            cpTest.setSchool("第一中学");
            System.out.println(cpTest.getSchool());
            //通过反射的方式
            Method met = cla.getMethod("setSchool", String.class);//可获取public方法
            met.invoke(cpTest, "第二中学");
            System.out.println(cpTest.getSchool());
            //通过反射强制调用private方法
            Method met1 = cla.getDeclaredMethod("setSchool");
            met1.setAccessible(true);//重要的，去除private封装
            met1.invoke(cpTest);
            System.out.println(cpTest.getSchool());
            /*
            第一中学
            第二中学
            第一中学
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//CPTest.java
package test2;

public class CPTest extends CTest implements Study, Move {
    public String name = "李四";
    public int age = 23;
    String school = "-中学";

    public CPTest() {
    }

    public CPTest(String name) {
        this.name = name;
    }

    private CPTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    private void setSchool() {
        this.school = "第一中学";
    }

    public void setSchool(String school) {
        this.school = school;
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
