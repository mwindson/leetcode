package Problem501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/7.
 * https://leetcode.com/problems/subarray-sum-equals-k/#/solutions
 */
public class Problem560 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int k = 7;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        // (sum,count)
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
