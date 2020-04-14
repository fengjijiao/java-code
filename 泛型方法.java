package test;

public class test13 {
    public static void main(String[] args) {
        //String类型
        PersonP personP = new PersonP();
        personP.setName("张三");
        System.out.println(personP.getName());
        PersonC<String> personC = new PersonC<String>();
        personC.setVal("张三");
        System.out.println(personC.getVal());
        PersonM personM = new PersonM();
        personM.setVal("张三");
        System.out.println(personM.getVal());
        //int类型
        PersonC<Integer> personCI = new PersonC<Integer>();
        personCI.setVal(3);
        System.out.println(personCI.getVal());
        PersonM personMI = new PersonM();
        personMI.setVal(3);
        System.out.println(personMI.getVal());
    }
}

/**
 * 普通类(未定义泛型)
 */
class PersonP {
    /**
     * 普通方法
     */
    String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
/**
 * 类泛型(类定义的泛型，可以在整个类中使用)
 */
class PersonC <T> {//接19行
    /**
     * 泛型方法
     * @author jijiao feng
     * @param T 泛型
     * @result void
     */
    T t;//注意：类泛型变量需要在类上声明<T>
    public void setVal(T t) {
        this.t = t;
    }
    public T getVal() {
        return t;
    }
}
/**
 * 方法泛型（方法定义的泛型，只能在方法中使用）
 * 为展示在这里使用了toString方法，因在类中无该泛型的定义，仅能在方法中使用
 */
class PersonM {
    /**
     * 泛型方法
     */
    String x;
    public <T> void setVal(T t) {
        x = t.toString();
    }
    public String getVal() {
        return x;
    }
}
