package test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//通过反射调用属性（变量）
public class test9 {
    public static void main(String[] args) {
        try {
            Class cla = Class.forName("test2.CPTest");
            Constructor con = cla.getConstructor();
            Object obj = con.newInstance();
            CPTest cpTest = (CPTest) obj;
            Field f = cla.getField("name");//获取public属性
            f.set(cpTest, "王五");
            System.out.println(f.get(cpTest));
            //利用反射可以实现调用私有方法/属性
            Field f1 = cla.getDeclaredField("school");
            //java.lang.IllegalAccessException: class test2.test9 cannot access a member of class test2.CPTest with modifiers "private"
            f1.setAccessible(true);//去除私有化封装
            f1.set(cpTest, "第一中学");
            System.out.println(f1.get(cpTest));
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
    private String school = "-中学";

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
