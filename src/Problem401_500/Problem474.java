package Problem401_500;

/**
 * Created by mwindson on 2017/5/25.
 * https://leetcode.com/problems/ones-and-zeroes/#/description
 */
public class Problem474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0" };
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = count(s);
            for (int i = m; i >= count[0]; i--)
                for (int j = n; j >= count[1]; j--)
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
        }
        return dp[m][n];
    }

    private static int[] count(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++)
            res[s.charAt(i) - '0']++;
        return res;
    }
}
