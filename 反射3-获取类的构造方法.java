//test4.java
package test2;

import java.lang.reflect.Constructor;

public class test4 {
    /**
     * 通过反射获取一个类的构造方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class cla = Class.forName("test2.CPTest");
            //获取所有修饰符为public的构造方法
            System.out.println("获取所有修饰符为public的构造方法");
            Constructor[] cons = cla.getConstructors();
            for(Constructor c: cons) {
                System.out.printf("构造方法：" + c.getName() + ",修饰符:" + c.getModifiers() + ",参数类型：");//修饰符为1表示public,2表示private
                Class[] params = c.getParameterTypes();
                for(Class pa: params) {
                    System.out.printf(pa.getName());
                }
                System.out.println();
            }
            //获取所有的构造方法
            System.out.println("获取所有的构造方法");
            Constructor[] cons1 = cla.getDeclaredConstructors();
            for(Constructor c: cons1) {
                System.out.printf("构造方法：" + c.getName() + ",修饰符:" + c.getModifiers() + ",参数类型：");//修饰符为1表示public,2表示private
                Class[] params = c.getParameterTypes();
                for(Class pa: params) {
                    System.out.printf(pa.getName());
                }
                System.out.println();
            }
            /*
            获取所有修饰符为public的构造方法
            构造方法：test2.CPTest,修饰符:1,参数类型：java.lang.String
            构造方法：test2.CPTest,修饰符:1,参数类型：
            获取所有的构造方法
            构造方法：test2.CPTest,修饰符:2,参数类型：java.lang.Stringint
            构造方法：test2.CPTest,修饰符:1,参数类型：java.lang.String
            构造方法：test2.CPTest,修饰符:1,参数类型：
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//CPTest.java
package test2;

public class CPTest extends CTest implements Study, Move {
    String name;
    int age;

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
//CTest.java
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
