package Problem701_800;

/**
 * Created by mwindson on 2018/1/22.
 * https://leetcode.com/problems/toeplitz-matrix/description/
 */
public class Problem766 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 4, 5}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int l = 0; l < m + n; l++) {
            int x = l < m ? l : 0;
            int y = l < m ? 0 : l - m;
            for (int i = 1; i + x < n && i + y < m; i++) {
                if (matrix[i + y][i + x] != matrix[i - 1 + y][i - 1 + x]) {
                    return false;
                }
            }
        }
        return true;
    }
}
