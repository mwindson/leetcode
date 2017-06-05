package Problem501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/5.
 * https://leetcode.com/problems/brick-wall/#/description
 */
public class Problem554 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 2, 1},
                {3, 1, 2},
                {1, 3, 2},
                {2, 4},
                {3, 1, 2},
                {1, 3, 1, 1},
        };
        List<List<Integer>> wall = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j : array[i])
                l.add(j);
            wall.add(l);
        }
        System.out.println(leastBricks(wall));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int prev = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    int len = list.get(i);
                    map.put(len + prev, map.getOrDefault(len + prev, 0) + 1);
                    prev = len + prev;
                }
            }
        }
        int max = 0;
        for (int count : map.keySet()) {
            max = Math.max(max, map.get(count));
        }
        return wall.size() - max;
    }
}
