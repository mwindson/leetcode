package Problem701_800;

/**
 * Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * @ dp
 * @ related p.712
 */
public class Problem718 {
    public static void main(String[] args) {
        int[] A = {0, 1, 1, 1, 1};
        int[] B = {1, 0, 1, 0, 1};
        System.out.println(findLength(A, B));
    }

    /**
     * 　　 1  2  3  2  1
     * 3　　0  0  1  0  0
     * 2　　0  1  0  2  0
     * 1　　1  0  0  0  3
     * 4    0  0  0  0  0
     * 7　　0  0  0  0  0
     */
    public static int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int max = 0;
        int[][] dp = new int[m][n]; // dp[i][j]: A.subArray(0,i) 与B.subArray(0,j)的最长公共子序列
        for (int i = 0; i < m; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = A[0] == B[j] ? 1 : 0;
            max = Math.max(dp[0][j], max);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
