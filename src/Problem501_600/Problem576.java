package Problem501_600;

/**
 * Created by mwindson on 2017/8/3.
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 */
public class Problem576 {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int N = 3;
        int i = 0, j = 0;
        System.out.println(findPaths(m, n, N, i, j));
    }

    // 三维DP
    public static int findPaths(int m, int n, int N, int i, int j) {
        if (N < 0) return 0;

        int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            // 超过边界时计算path
                            result = (result + dp[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }
        return result;
    }
}
