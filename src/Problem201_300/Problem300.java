package Problem201_300;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/5/11.
 * https://leetcode.com/problems/longest-increasing-subsequence/#/description
 */
public class Problem300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    // [10] -> [9] -> [2,5] -> [2,3,7,101] ->[2,3,7,18]
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x); //if it is contained in the array, else it returns (-(insertion point) - 1).
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }
}
