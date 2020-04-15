//test6.java
package test2;

import java.lang.reflect.Method;

/**
 * 通过反射获取类的方法
 */
public class test6 {

    public static void main(String[] args) {
        try {
            Class cla = Class.forName("test2.CPTest");
            //获取类的方法（public）
            System.out.println("获取类的方法（public）");
            Method[] mes = cla.getMethods();
            for(Method m: mes) {
                System.out.println("方法名：" + m.getName());
                System.out.println("修饰符：" + m.getModifiers());
                System.out.println("返回值类型：" + m.getReturnType());
                Class[] pas = m.getParameterTypes();
                if (pas != null && pas.length > 0) {
                    System.out.printf("参数类型：");
                    for (Class c : pas) {
                        System.out.printf(c.getName());
                    }
                    System.out.println();
                }
            }
                /*
                 * 方法名：MoveType
                 *修饰符：1
                 *返回值类型：void
                 *方法名：StudyWhat
                 *修饰符：1
                 *返回值类型：void
                 *方法名：setA
                 *修饰符：1
                 *返回值类型：void
                 *参数类型：int
                 *方法名：getA
                 *修饰符：1
                 *返回值类型：int
                 *方法名：wait
                 *修饰符：273
                 *返回值类型：void
                 *参数类型：long
                 *方法名：wait
                 *修饰符：17
                 *返回值类型：void
                 *参数类型：longint
                 *方法名：wait
                 *修饰符：17
                 *返回值类型：void
                 *方法名：equals
                 *修饰符：1
                 *返回值类型：boolean
                 *参数类型：java.lang.Object
                 *方法名：toString
                 *修饰符：1
                 *返回值类型：class java.lang.String
                 *方法名：hashCode
                 *修饰符：257
                 *返回值类型：int
                 *方法名：getClass
                 *修饰符：273
                 *返回值类型：class java.lang.Class
                 *方法名：notify
                 *修饰符：273
                 *返回值类型：void
                 *方法名：notifyAll
                 *修饰符：273
                 *返回值类型：void
                 */
                //获取类的方法（public）
            System.out.println("获取类的所有方法");
            Method[] mes1 = cla.getMethods();
            for(Method m1: mes1) {
                System.out.println("方法名：" + m1.getName());
                System.out.println("修饰符：" + m1.getModifiers());
                System.out.println("返回值类型：" + m1.getReturnType());
                Class[] pas1 = m1.getParameterTypes();
                if(pas1 != null && pas1.length > 0) {
                    System.out.printf("参数类型：");
                    for (Class c1 : pas1) {
                        System.out.printf(c1.getName());
                    }
                    System.out.println();
                }
            }
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
