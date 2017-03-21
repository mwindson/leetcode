package Problem001_100;

/**
 * Created by mwindson on 2017/3/21.
 * https://leetcode.com/problems/maximum-subarray/#/solutions
 */
public class problem053 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // 得到一个大的子数组
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            // 更新最大子数组
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
