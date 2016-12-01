import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Problem463 {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        boolean left = false, top = false, right = false, bottom = false;
        for (int j = 0; j < grid.length; j++) { // each row
            for (int i = 0; i < grid[j].length; i++) { // each column
                if (grid[j][i] == 1) {
                    perimeter += 4;
                    if (i == 0) {
                        left = true;
                    }
                    if (i == grid[j].length - 1) {
                        right = true;
                    }
                    if (j == 0) {
                        top = true;
                    }
                    if (j == grid.length - 1){
                        bottom = true;
                    }
                    // deal with the island
                    if (!left) {
                        if (grid[j][i - 1] == 1) {
                            perimeter--;
                        }
                    }
                    if (!right) {
                        if (grid[j][i + 1] == 1) {
                            perimeter--;
                        }
                    }
                    if (!top) {
                        if (grid[j - 1][i] == 1) {
                            perimeter--;
                        }
                    }
                    if (!bottom) {
                        if (grid[j + 1][i] == 1) {
                            perimeter--;
                        }
                    }
                    //clear
                    left = right = top = bottom = false;
                }
            }
        }

        return perimeter;
// the simplest
//        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//        int result = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    result += 4;
//                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
//                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
//                }
//            }
//        }
//        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}};
        System.out.print(islandPerimeter(grid));
    }
}
