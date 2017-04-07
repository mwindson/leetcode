package Problem201_300;

/**
 * Created by mwindson on 2017/4/7.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/#/description
 */
public class Problem240 {
    public static void main(String[] args) {
        int[][] martrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30},
                {}
        };
        System.out.println(searchMatrix(martrix, 28));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        boolean canFind = false;
        int i = 0;
        int j = matrix[0].length - 1;
        int start = matrix[i][j];
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                canFind = true;
                break;
            } else if (target > matrix[i][j]) {
                if (i == matrix.length - 1) {
                    canFind = false;
                    break;
                } else {
                    i++;
                }
            } else {
                if (j == 0) {
                    canFind = false;
                    break;
                } else {
                    j--;
                }
            }
        }
        return canFind;
    }
}
