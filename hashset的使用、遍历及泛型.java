package test;

import java.util.HashSet;
import java.util.Iterator;

public class test4 {
    public static void main(String[] args) {
        /*
        HashSet是无序的（利用hashcode值排序）、不能重复的(hashcode值不能一致)
        基本数据类型会自动转为相应对象(int -->Integer)
         */
        HashSet hs1 = new HashSet();
        hs1.add("a");
        hs1.add(2);
        hs1.add(true);
        hs1.add("c");
        System.out.println(hs1);
        /*
        [a, 2, c, true]
         */
        hs1.remove("a");
        System.out.println(hs1);
        /*
        [2, c, true]
         */
        hs1.add("c");//重复添加无效
        System.out.println(hs1);
        /*
        [2, c, true]
         */
        hs1.add(new String("c"));//重复添加无效
        System.out.println(hs1);
        /*
        [2, c, true]
         */
        boolean isContainC = hs1.contains("c");
        System.out.printf("%s,是否包含C:%s\n", hs1, isContainC);
        /*
        [2, c, true],是否包含C:true
         */
        System.out.println("集合长度:"+hs1.size());
        /*
        集合长度:3
         */
        //遍历元素（2种方法）
        Iterator iterator = hs1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for(Object obj: hs1) {
            System.out.println(obj);
        }
        /*
        2
        c
        true
         */
        //<>表示泛型：仅能存一种数据
        HashSet<Integer> hs2 = new HashSet<Integer>();
        //...
    }
}
