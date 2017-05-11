package Problem301_400;

/**
 * Created by mwindson on 2017/5/11.
 * https://leetcode.com/problems/range-sum-query-immutable/#/description
 */
public class Problem303 {
    static class NumArray {
        int[] dp;

        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            dp[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return dp[j + 1] - dp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 2));
        System.out.println(obj.sumRange(0, 5));
    }
}

