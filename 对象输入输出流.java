package test;

import java.io.*;

public class test26 {
    /**
     * 对象输入输出流
     * 注意：类对象的包名，类名，结构必须完全一致，否则会报cast错误
     */
    public static void main(String[] args) {
        String filePath = "aaa.txt";
        try{
            SerialTest(filePath);
            DeSerialTest(filePath);
        }catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        file.delete();
    }
    public static void SerialTest(String filePath) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filePath));
        Person2 person2 = new Person2();
        person2.name = "张三";
        person2.age = 13;
        out.writeObject(person2);
        out.flush();
        out.close();
    }
    public static void DeSerialTest(String filePath) throws Exception {
        ObjectInput in = new ObjectInputStream(new FileInputStream(filePath));
        Object obj = in.readObject();
        in.close();
        Person2 person2 = (Person2) obj;
        System.out.println(person2.name + "，" + person2.age);
    }
}
class Person2 implements Serializable {
    private static long serialVersionUID = 1;
    public String name;
    public int age;
}
