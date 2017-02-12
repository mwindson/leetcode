package Problem001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/2/12.
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Problem054 {
    public static void main(String[] args) {
        int[][] matrix = {};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int col = matrix.length;
        if (col == 0) return result;
        int row = matrix[0].length;
        int top = 0, bottom = col - 1, left = 0, right = row - 1;
        while (top <= bottom && left <= right) {
            // top: left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            // right: top to bottom
            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;
            if (left > right) break;
            // bottom: right to left
            for (int m = right; m >= left; m--) {
                result.add(matrix[bottom][m]);
            }
            bottom--;
            if (top > bottom) break;
            for (int n = bottom; n >= top; n--) {
                result.add(matrix[n][left]);
            }
            left++;
            if (left > right) break;
        }

        return result;
    }
}
