package Problem001_100;

/**
 * Created by mwindson on 2017/2/24.
 * https://leetcode.com/problems/search-a-2d-matrix/?tab=Description
 */
public class Problem074 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 11;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean canFind = false;
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int leftCol = 0, leftRow = 0, rightCol = matrix[0].length - 1, rightRow = matrix.length - 1;
        while (leftCol <= rightCol || leftRow <= rightRow) {
            if (matrix[leftRow][leftCol] == target || matrix[rightRow][rightCol] == target) {
                canFind = true;
                break;
            }
            if (matrix[leftRow][leftCol] < target) {
                leftCol++;
            } else {
                break;
            }
            if (leftCol >= matrix[0].length) {
                leftCol = 0;
                leftRow++;
            }
            if (matrix[rightRow][rightCol] > target) {
                rightCol--;
            } else {
                break;
            }
            if (rightCol < 0) {
                rightCol = matrix[0].length - 1;
                rightRow--;
            }
        }
        return canFind;
    }
}
