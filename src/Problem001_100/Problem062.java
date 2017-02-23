package Problem001_100;

/**
 * Created by mwindson on 2017/2/23.
 * https://leetcode.com/problems/unique-paths/?tab=Description
 */
public class Problem062 {
    public static void main(String[] args) {
        int m = 10, n = 10;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
