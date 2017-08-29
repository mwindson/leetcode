package Problem600_700;

import java.util.Map;

/**
 * Created by mwindson on 2017/8/2.
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class Problem643 {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int max = sum;
        for (int i = 0; i + k < nums.length; i++) {
            sum = sum - nums[i] + nums[i + k];
            max = Math.max(sum, max);
        }
        return max * 1.0 / k;
    }
}
