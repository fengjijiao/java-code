package test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class test5 {
    public static void main(String[] args) {
        //TreeSet是sortedset接口的实现类
        //可以确保集合处于排序状态
        //有自然排序和定制排序
        //自然排序
        Set<Integer> s1 = new TreeSet<Integer>();
        s1.add(20);
        s1.add(16);
        s1.add(24);
        s1.add(14);
        System.out.println(s1);
        /*
        [14, 16, 20, 24]
         */
        /*
        遍历
         */
        Iterator it = s1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //或者
        for (Integer i: s1) {
            System.out.println(i);
        }
        /*
        14
        16
        20
        24
         */


        //定制排序
        Set<Person> s2 = new TreeSet<Person>(new Person());
        Person p1 = new Person(20, "Lax");
        Person p2 = new Person(13, "ben");
        Person p3 = new Person(16, "axs");
        s2.add(p1);
        s2.add(p2);
        s2.add(p3);
        for (Person p: s2) {
            System.out.printf("年龄：%d,姓名：%s\n", p.age, p.name);
        }
        /*
        年龄：13,姓名：ben
        年龄：16,姓名：axs
        年龄：20,姓名：Lax
         */
    }
}
class Person implements Comparator<Person> {//Comparator
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.age> o2.age) {
            return 1;
        }else if(o1.age< o2.age) {
            return -1;
        }else {
            return 0;
        }
    }
}
