package Problem001_100;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mwindson on 2017/2/24.
 * https://leetcode.com/problems/set-matrix-zeroes/?tab=Description
 */
public class Problem073 {
    public static void main(String[] args) {
        int[][] matrix = {{0}, {1}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for (int m : col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][m] = 0;
            }
        }
        for (int n : row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[n][i] = 0;
            }
        }
    }
}
