package Problem501_600;

/**
 * Created by mwindson on 2017/5/23.
 * https://leetcode.com/problems/reshape-the-matrix/#/description
 */
public class Problem566 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},
                {3, 4},
                {9, 8}};
        System.out.println(matrixReshape(nums, 2, 3));
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) return nums;
        if (r * c != nums.length * nums[0].length) return nums;
        int[][] matrixRe = new int[r][c];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                matrixRe[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return matrixRe;
    }
}
