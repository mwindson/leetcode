package Problem301_400;

/**
 * Created by mwindson on 2017/5/11.
 * https://leetcode.com/problems/range-sum-query-2d-immutable/#/description
 */
public class Problem304 {
    static class NumMatrix {
        int dp[][];

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) return;
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = 0;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
