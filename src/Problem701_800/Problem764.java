package Problem701_800;

import java.util.Arrays;

/**
 * 764. Largest Plus Sign
 * https://leetcode.com/problems/largest-plus-sign/description/
 *
 * @ tag dp
 */
public class Problem764 {
    public static void main(String[] args) {
        int N = 5;
        int[][] mines = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(N, mines));
    }

    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int[] g : grid) {
            Arrays.fill(g, N);
        }
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = 0;
            int up = 0;
            int down = 0;
            for (int j = 0; j < N; j++) {
                int k = N - 1 - j;
                left = grid[i][j] == 0 ? 0 : left + 1;
                right = grid[i][k] == 0 ? 0 : right + 1;
                up = grid[j][i] == 0 ? 0 : up + 1;
                down = grid[k][i] == 0 ? 0 : down + 1;
                grid[i][j] = Math.min(grid[i][j], left);
                grid[i][k] = Math.min(grid[i][k], right);
                grid[j][i] = Math.min(grid[j][i], up);
                grid[k][i] = Math.min(grid[k][i], down);
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
}
