package test;

import java.util.ArrayList;
import java.util.List;

public class test7 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(4);
        System.out.println(list);
        /*
        [1, 2, 5, 3, 4]
         */
        list.remove(3);//元素
        System.out.println(list);
        /*
        [1, 2, 5, 4]
         */
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(9);
        list2.add(5);
        list.addAll(list2);
        System.out.println(list);
        /*
        [1, 2, 5, 4, 6, 9, 5]
         */
        System.out.println(list.get(3));//索引
        /*
        4
         */
        System.out.println(list.indexOf(5));
        /*
        2
         */
        System.out.println(list.lastIndexOf(5));
        /*
        6
         */
    }
}
