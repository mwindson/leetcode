package Problem600_700;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/9/19.
 * https://leetcode.com/problems/map-sum-pairs/description/
 */
public class Problem677 {
    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("apple"));
        obj.insert("apple", 2);
        System.out.println(obj.sum("apple"));
        obj.insert("apple", 1);
        System.out.println(obj.sum("apple"));
    }

    static class MapSum {
        Map<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String str : map.keySet()) {
                if (str.startsWith(prefix)) {
                    sum += map.get(str);
                }
            }

            return sum;
        }
    }
}
