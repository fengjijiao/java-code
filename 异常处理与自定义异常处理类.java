package test;

public class test3 {
    public static void main(String args[]) {
        /*
        异常的捕获1(try,catch)
         */
        int x=10;
        int z = 0;
        try {
            z=x/0;
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sum of x/0 = " + z);
        /*
        Sum of x/0 = 0
        java.lang.ArithmeticException: / by zero
	    at MyClass.main(MyClass.java:7)
        */
        /*
        异常的捕获2
         */
        B b = null;
        int y =0;
        try {
            y = b.a;
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("y = " + y);
        /*
        y = 0
        java.lang.NullPointerException
	    at test.test3.main(test3.java:23)
         */
        /*
        抛出异常(throw,throws)
         */
        C c = new C();
        try {
            c.setAge(-100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("age:" + c.getAge());
        /*
        age:0
        java.lang.Exception: 年龄不在0~100的范围内！
	    at test.C.setAge(test3.java:51)
	    at test.test3.main(test3.java:35)
         */
        /*
        自定义异常类(throw,throws,extends)DException
         */
        D d = new D(15000);
        try {
            d.showInfo();
        } catch (DException e) {
            e.printStackTrace();
            System.out.printf("DException ID: %d\n", e.getId());
        }
        /*
        test.DException: 薪水不得低于16000!
	    at test.D.showInfo(test3.java:102)
	    at test.test3.main(test3.java:60)
	    DException ID: 12
         */
    }
}
class B {
    int a = 2;
}
class C {
    private int age;
    public void setAge(int age) throws Exception {
        if(age>0 && age<100) {
            this.age = age;
        }else {
            throw new Exception("年龄不在0~100的范围内！");
        }
    }
    public int getAge() {
        return age;
    }
}
class DException extends Exception {
    private int id = 0;
    public DException(String message) {
        super(message);
        this.id = message.length();
    }

    public int getId() {
        return id;
    }
}
class D {
    int salary;

    public D(int salary) {
        this.salary = salary;
    }

    public void showInfo() throws DException {
        if(salary<16000) {
            throw new DException("薪水不得低于16000!");
        }else {
            System.out.printf("姓名：张三，\n职务：产品经理\n薪水：%d\n", salary);
        }
    }
}
