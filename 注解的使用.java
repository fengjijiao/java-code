package test;

import java.lang.annotation.*;

public class test16 {
    public static void main(String[] args) {
        OneStudent oneStudent = new OneStudent();
        oneStudent.setName("李四");
        oneStudent.setAge(22);
        System.out.println(oneStudent.getName1());//会有删除线
        System.out.println(oneStudent.getName());
    }
    static class OneSudentDivAnnTest {
        //自定义注解
        @DivAnn(id=3,desc="年龄")
        int age;
        @DivAnn(id=3,desc="姓名")
        String name;
    }
}
class OneStudent {
    String name;
    int age;
    @Deprecated
    public String getName1() {
        return "张三";
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
/*自定义注解
 */
@Target(ElementType.FIELD)//这个注解类给其他类的属性做注解
@Retention(RetentionPolicy.RUNTIME)//定义注解的声明周期
@Documented
@interface DivAnn {
    public int id() default 0;
    public String desc() default "";
}
