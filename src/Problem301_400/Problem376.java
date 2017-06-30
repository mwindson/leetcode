package Problem301_400;

/**
 * Created by mwindson on 2017/6/30.
 * https://leetcode.com/problems/wiggle-subsequence/#/description
 */
public class Problem376 {
    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 8, 5, 16, 10, 8};
        System.out.println(wiggleMaxLength(nums));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5, 1
            k++;
        }
        if (k == nums.length - 1) {
            return 1;
        }
        int maxLen = 2;     // This will track the result of result array
        boolean up = nums[k] < nums[k + 1];       //To check series starting pattern
        for (int i = k + 1; i < nums.length - 1; i++) {
            if ((up && nums[i + 1] < nums[i]) || (!up && nums[i + 1] > nums[i])) {
                maxLen++;
                up = !up;
            }
        }
        return maxLen;
    }
}
