package Problem701_800;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 */
public class Problem712 {
    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    /**
     * dp[i][j] = a[i] == b[j] ? dp[i + 1][j + 1] :
     * min(a[i] + dp[i + 1][j],  // delete a[i] + minimumDeleteSum(a.substr(i+1), b.substr(j))
     * b[j] + dp[i][j + 1])  // delete b[j] + minimumDeleteSum(a.substr(i), b.substr(j+1))
     */
    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length(), MAX = Integer.MAX_VALUE;
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m || j < n)
                    dp[i][j] = i < m && j < n && a[i] == b[j] ?
                            dp[i + 1][j + 1] : Math.min((i < m ? a[i] + dp[i + 1][j] : MAX), (j < n ? b[j] + dp[i][j + 1] : MAX));
            }
        }
        return dp[0][0];
    }
}
