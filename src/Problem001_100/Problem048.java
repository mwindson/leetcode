package Problem001_100;

/**
 * Created by mwindson on 2017/2/23.
 * https://leetcode.com/problems/rotate-image/?tab=Description
 */
public class Problem048 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int tmp = 0;
        int n = matrix.length;
        int loop = 0;
        for (int j = 0; j < n / 2; j++) {
            for (int i = j; i < n - j - 1; i++) {
                tmp = matrix[j][i];
                matrix[j][i] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
