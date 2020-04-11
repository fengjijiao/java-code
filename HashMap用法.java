package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test8 {
    public static void main(String[] args) {
        /*
        HashMap按自然顺序排序
         */
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("d", 4);
        map.put("b", 3);
        map.put("c", 44);
        System.out.println(map);
        /*
        {a=1, b=3, c=44, d=4}
         */
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(10, "v");
        map1.put(4, "d");
        map1.put(3, "vd");
        map1.put(44, "ww");
        System.out.println(map1);
        /*
        {3=vd, 4=d, 10=v, 44=ww}
         */
        /*
        遍历1
         */
        Set<Integer> keys = map1.keySet();
        System.out.println(keys);
        /*
        [3, 4, 10, 44]
         */
        for (Integer k: keys ) {
            System.out.printf("%d --> %s \n", k, map1.get(k));
        }
        /*
        3 --> vd
        4 --> d
        10 --> v
        44 --> ww
         */
        /*
        遍历2
         */
        Set<Map.Entry<Integer, String>> entries = map1.entrySet();
        for (Map.Entry<Integer, String> en: entries) {
            System.out.printf("%d --> %s \n", en.getKey(), en.getValue());
        }
        /*
        3 --> vd
        4 --> d
        10 --> v
        44 --> ww
         */
    }
}
