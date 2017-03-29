package Problem001_100;

/**
 * Created by mwindson on 2017/3/29.
 * https://leetcode.com/problems/unique-paths-ii/#/description
 */
public class Problem063 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                if (i == 0 && j != 0)
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1];
                if (j == 0 && i != 0)
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j];
                if (i != 0 && j != 0)
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1] + dp[i - 1][j];
            }
        }
        int res = dp[row - 1][col - 1];
        return res;
    }
}
