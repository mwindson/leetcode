package Problem101_200;

/**
 * Created by mwindson on 2017/3/15.
 * https://leetcode.com/problems/house-robber/#/description
 */
public class Problem198 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }

    // DP:ith房子最大可能性=ith房子钱+i-2th房子钱和i-1th房子钱的最大值
    public static int rob(int[] nums) {
        if (nums.length <= 1)
            return nums.length == 0 ? 0 : nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }
}
