package Problem600_700;

/**
 * Created by mwindson on 2017/8/29.
 * https://leetcode.com/problems/non-decreasing-array/description/
 */
public class Problem665 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;                                             //the number of changes
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];                       //modify nums[i-1] of a priority
                else nums[i] = nums[i - 1];                      //have to modify nums[i]
            }
        }
        return cnt <= 1;
    }
}
