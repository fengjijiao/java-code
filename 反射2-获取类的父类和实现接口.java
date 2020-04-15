//test3.java
package test2;

public class test3 {
    /**
     * 通过反射获取一个类的父类和接口
     * @param args
     */
    public static void main(String[] args) {
        CPTest cpTest = new CPTest();
        Class cla = cpTest.getClass();
        Class claSuperClass = cla.getSuperclass();
        System.out.println("父类：" + claSuperClass.getName());
        Class[] claInterfaces = cla.getInterfaces();
        for(Class c: claInterfaces) {
            System.out.println("接口：" + c.getName());
        }
        /*
        父类：test2.CTest
        接口：test2.Study
        接口：test2.Move
         */
    }
}
//CPTest.java
package test2;

public class CPTest extends CTest implements Study, Move {
    String name;
    int age;
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
