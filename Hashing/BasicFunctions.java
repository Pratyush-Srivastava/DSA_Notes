package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicFunctions {
    public static void main(String[] args) {
        //using hashset
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(10);
        System.out.println(set.contains(5));
        set.remove(10);
        set.add(90);
        System.out.println(set.contains(10));
        for (Integer key : set) {
            System.out.println(key);

        }
        set.clear();
        System.out.println(set.isEmpty());

        //using hashmaps
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3,5);
        map.put(2,0);
        System.out.println(map.containsKey(2));
        map.remove(2);
        System.out.println(map.containsKey(2));
        map.put(8,10);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key: " + key + " value: " + value);
        }
        map.clear();
        System.out.println(map.isEmpty());
    }
}
