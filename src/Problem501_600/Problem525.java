package Problem501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/7.
 * https://leetcode.com/problems/contiguous-array/#/description
 */
public class Problem525 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count0 = 0, count1 = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            else count1++;
            List<Integer> list = map.getOrDefault(count0 - count1, new ArrayList<>());
            list.add(i);
            map.put(count0 - count1, list);
        }
        for (int i : map.keySet()) {
            if (i == 0) {
                for (int index : map.get(i)) {
                    maxLen = Math.max(index + 1, maxLen);
                }
            } else if (map.get(i).size() > 1) {
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int index : map.get(i)) {
                    min = Math.min(index, min);
                    max = Math.max(index, max);
                }
                maxLen = Math.max(maxLen, max - min);
            }
        }
        return maxLen;
    }
}
