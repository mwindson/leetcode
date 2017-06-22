package Problem301_400;

/**
 * Created by mwindson on 2017/6/20.
 * https://leetcode.com/problems/burst-balloons/#/solutions
 */
public class Problem312 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        //dp[i][j]从i到j可以得到的最大硬币数
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    // 第i个为这部分中最后消除的气球
                    int coins = nums[i] * (start - 1 >= 0 ? nums[start - 1] : 1) * (end + 1 < nums.length ? nums[end + 1] : 1);
                    coins += i != start ? dp[start][i - 1] : 0;
                    coins += i != end ? dp[i + 1][end] : 0;
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
