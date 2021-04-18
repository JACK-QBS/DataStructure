package MyHashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class useHashTable {
    public static void main(String[] args) {
        /*
        //HashSet 的使用
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);//不保证顺序

        System.out.println(set.add(1));
        System.out.println(set.remove(2));
        System.out.println(set);

        System.out.println(set.contains(3));
        System.out.println(set.contains(2));*/

        //HashMap 的使用
        Map<String,Integer> map = new HashMap<>();

        System.out.println(map.put("qbs", 666));
        System.out.println(map.put("ml", 32));
        map.put("hh",3);
        map.put("sxa",231);

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.get("qbs"));
        System.out.println(map.remove("hh"));
        System.out.println();
    }
}
