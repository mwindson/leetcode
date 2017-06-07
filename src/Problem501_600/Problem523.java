package Problem501_600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mwindson on 2017/6/7.
 * https://leetcode.com/problems/continuous-subarray-sum/#/description
 */
public class Problem523 {
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = -6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // Since the size of subarray is at least 2.
        if (nums.length <= 1) return false;
        // Two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }

        // At this point, k can't be "0" any longer.
        if (k == 0) return false;
        // Let's only check positive k. Because if there is a n makes n * k = sum, it is always true -n * -k = sum.
        if (k < 0) k = -k;

        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        sums.add(0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i > 0) {
                // Validate from the biggest possible n * k to k
                for (int j = (sum / k) * k; j >= k; j -= k) {
                    if (sums.contains(sum - j)) return true;
                }
            }

            sums.add(sum);
        }

        return false;
    }
}
