package Problem201_300;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/3/26.
 * https://leetcode.com/problems/perfect-squares/#/description
 */
public class Problem279 {
    public static void main(String[] args) {
        System.out.println(numSquares(50));
    }

    // dp[i]=min(dp[i-1]+1,dp[i-4]+1,dp[i-9]+1,…………dp[i-j*j]+1)
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
