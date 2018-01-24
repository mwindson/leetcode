package Problem401_500;

import java.util.*;

/**
 * https://leetcode.com/problems/frog-jump/description/
 * 403. Frog Jump
 *
 * @ type dp
 */
public class Problem403 {
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));
    }

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        if (n <= 1) return true;
        // <stonePos,steps>
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int nextStone = stone + step;
                if (nextStone == stones[n - 1]) return true;
                Set<Integer> steps = map.get(nextStone);
                if (steps != null) {
                    steps.add(step);
                    if (step - 1 > 0) steps.add(step - 1);
                    steps.add(step + 1);
                }
            }
        }
        return false;
    }
}
