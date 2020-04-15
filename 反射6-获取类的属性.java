package test2;

import java.lang.reflect.Field;

/*
获取类的属性（变量）
 */
public class test7 {
    public static void main(String[] args) {
        try {
            Class cla = Class.forName("test2.CPTest");
            Field[] fds = cla.getFields();//获取所有public属性,包含父类
            for(Field fd: fds) {
                System.out.println("属性名：" + fd.getName());
                System.out.println("修饰符：" + fd.getModifiers());
                System.out.println("属性类型：" + fd.getType());
                System.out.println();
            }
            /*
            属性名：name
            修饰符：1
            属性类型：class java.lang.String

            属性名：age
            修饰符：1
            属性类型：int
             */
            Field[] fds1 = cla.getDeclaredFields();//获取所有属性,不包含父类
            for(Field fd1: fds1) {
                System.out.println("属性名：" + fd1.getName());
                System.out.println("修饰符：" + fd1.getModifiers());
                System.out.println("属性类型：" + fd1.getType());
                System.out.println();
            }
            /*
            属性名：name
            修饰符：1
            属性类型：class java.lang.String

            属性名：age
            修饰符：1
            属性类型：int

            属性名：school
            修饰符：0
            属性类型：class java.lang.String
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
