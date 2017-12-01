package Problem701_800;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/12/1.
 * https://leetcode.com/problems/flood-fill/description/
 */
public class Problem733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return new int[0][0];
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        dfs(image, sc, sr, visited);
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    private static void dfs(int[][] image, int x, int y, boolean[][] visited) {
        int[][] dirs = {{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};
        for (int[] dir : dirs) {
            if (dir[0] >= 0 && dir[0] < image[0].length && dir[1] >= 0 && dir[1] < image.length && !visited[dir[1]][dir[0]] && image[y][x] == image[dir[1]][dir[0]]) {
                visited[dir[1]][dir[0]] = true;
                dfs(image, dir[0], dir[1], visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 2, newColor = 2;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, newColor)));
    }
}
