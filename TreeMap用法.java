package test;

import java.util.Map;
import java.util.TreeMap;

public class test9 {
    public static void main(String[] args) {
        /*
        TreeMap按字典顺序排序
         */
        /*
        自然排序
         */
        Map<String, Integer> map = new TreeMap<>();
        map.put("e", 3);
        map.put("q", 5);
        map.put("r", 1);
        map.put("a", 9);
        map.put("t", 99);
        System.out.println(map);
        /*
        {a=9, e=3, q=5, r=1, t=99}
         */
        /*
        定制排序
         */
    }
}
