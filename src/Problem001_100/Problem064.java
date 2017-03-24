package Problem001_100;

/**
 * Created by mwindson on 2017/3/24.
 * https://leetcode.com/problems/minimum-path-sum/#/description
 */
public class Problem064 {
    public static void main(String[] args) {
        int[][] grid = {{1}};
        System.out.println(minPathSum(grid));
    }

    // 到grid[i][j]的最小数和等于前一个点（有两个方向）最小数和+当前点的数
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if (i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                else
                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
