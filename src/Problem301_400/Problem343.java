package Problem301_400;

/**
 * Created by mwindson on 2017/5/15.
 * https://leetcode.com/problems/integer-break/#/description
 */
public class Problem343 {
    public static void main(String[] args) {
        for (int i = 4; i <= 20; i++) {
            System.out.println(integerBreak(i));
        }
    }

    // dp 只需要比较*2和*3的大小就可以，因为2*2=4,2*3>5,之后的因子都不如2和3的组合
    public static int integerBreak(int n) {
        if (n <= 3) {
            if (n == 1 || n == 2)
                return 1;
            else
                return 2;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }
}
