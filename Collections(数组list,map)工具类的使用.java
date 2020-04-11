package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test10 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("s");
        list.add("a");
        list.add("c");
        list.add("ac");
        list.add("cs");
        System.out.println(list);
        /*
        [s, a, c, ac, cs]
         */
        //Collections.fill(list, "c");
        //System.out.println(list);
        /*
        [c, c, c, c, c]
         */
        Collections.reverse(list);//反转
        System.out.println(list);
        /*
        [cs, ac, c, a, s]
         */
        String max = Collections.max(list);
        String min = Collections.min(list);
        System.out.println("max:"+max+",min:"+min);
        /*
        max:s,min:a
         */
        Collections.sort(list);
        System.out.println(list);
        /*
        [a, ac, c, cs, s]
         */
        Student student = new Student(18, "zhans");
        Student student1 = new Student(12, "zhen");
        Student student2 = new Student(15, "feng");
        Student student3 = new Student(22, "wang");
        Student student4 = new Student(20, "q");
        List<Student> list1 = new ArrayList<>();
        list1.add(student);
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        list1.add(student4);
        System.out.println(list1);
        /*
        [test.Student@1ddc4ec2, test.Student@133314b, test.Student@b1bc7ed, test.Student@7cd84586, test.Student@30dae81]
         */
        Collections.sort(list1, new Student());
        System.out.println(list1);
    }
}

class Student implements Comparator<Student> {
    int age;
    String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.age > s2.age) {
            return 1;
        }else if(s1.age < s2.age) {
            return -1;
        }else {
            return 0;
        }
    }
}
