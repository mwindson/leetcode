package Problem600_700;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/11/16.
 * https://leetcode.com/problems/degree-of-an-array/description/
 */
public class Problem697 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    static class Sub {
        int start;
        int end;
        int count;

        Sub() {
            start = -1;
            end = -1;
            count = 0;
        }
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Sub> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Sub s = map.getOrDefault(nums[i], new Sub());
            s.count++;
            if (s.start == -1) {
                s.start = s.end = i;
            } else {
                s.end = Math.max(s.end, i);
            }
            map.put(nums[i], s);
        }
        int degree = 0;
        int minLen = Integer.MAX_VALUE;
        for (Sub s : map.values()) {
            if (s.count > degree) {
                minLen = s.end - s.start + 1;
                degree = s.count;
            } else if (s.count == degree) {
                minLen = Math.min(minLen, s.end - s.start + 1);
            }
        }
        return minLen;
    }
}
