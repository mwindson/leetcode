/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    void dfs(int i, int j, int[][] grid) {
        if (i < 0 ||  i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }
        area += grid[i][j];
        grid[i][j] = 0;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
// @lc code=end
