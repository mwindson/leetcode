package Problem201_300;

/**
 * Created by mwindson on 2017/3/15.
 * https://leetcode.com/problems/house-robber-ii/#/description
 */
public class Problem213 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1};
        System.out.println(rob(nums));
    }

    // 分两次DP计算，再比较最大值
    public static int rob(int[] nums) {
        if (nums.length <= 1)
            return nums.length == 0 ? 0 : nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        // 0-length-2
        int[] sum1 = new int[nums.length - 1];
        sum1[0] = nums[0];
        sum1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++)
            sum1[i] = Math.max(nums[i] + sum1[i - 2], sum1[i - 1]);
        // 1-legnth-1
        int[] sum2 = new int[nums.length - 1];
        sum2[0] = nums[1];
        sum2[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++)
            sum2[i - 1] = Math.max(nums[i] + sum2[i - 3], sum2[i - 2]);
        return Math.max(sum1[sum1.length - 1], sum2[sum2.length - 1]);
    }
}
