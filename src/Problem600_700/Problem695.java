package Problem600_700;

/**
 * Created by mwindson on 2017/10/9.
 */
public class Problem695 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    static int max = 0;
    static int area = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    max = Math.max(max, area);
                    area = 0;
                }
            }
        }
        return max;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[i][j] = true;
        area++;
        for (int[] dir : dirs) {
            int x = dir[0] + j;
            int y = dir[1] + i;
            if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] == 1 && !visited[y][x]) {
                dfs(grid, visited, y, x);
            }
        }
    }
}
