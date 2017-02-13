package Problem001_100;

/**
 * Created by mwindson on 2017/2/13.
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class Problem059 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateMatrix(n));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }
            top++;
            if (left > right) break;
            for (int j = top; j <= bottom; j++) {
                matrix[j][right] = num;
                num++;
            }
            right--;
            if (top > bottom) break;
            for (int m = right; m >= left; m--) {
                matrix[bottom][m] = num;
                num++;
            }
            bottom--;
            if (top > bottom) break;
            for (int k = bottom; k >= top; k--) {
                matrix[k][left] = num;
                num++;
            }
            left++;
            if (left > right) break;
        }

        return matrix;
    }
}
