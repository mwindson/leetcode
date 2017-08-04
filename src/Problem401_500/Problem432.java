package Problem401_500;

import java.util.*;

/**
 * Created by mwindson on 2017/8/3.
 * https://leetcode.com/problems/all-oone-data-structure/description/
 */
public class Problem432 {
    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("A");
        obj.dec("A");
        obj.inc("B");
        obj.dec("B");
        obj.dec("B");
        obj.dec("B");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }

    public static class AllOne {
        Map<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            map = new HashMap<>();
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            if (map.containsKey(key)) {
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (map.size() == 0) return "";
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            //升序排序
            list.sort(Comparator.comparing(Map.Entry::getValue));
            return list.get(list.size() - 1).getKey();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if (map.size() == 0) return "";
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            //升序排序
            list.sort(Comparator.comparing(Map.Entry::getValue));
            return list.get(0).getKey();
        }
    }
}
