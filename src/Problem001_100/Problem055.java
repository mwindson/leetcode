package Problem001_100;

/**
 * Created by mwindson on 2017/2/12.
 * https://leetcode.com/problems/jump-game/
 */
public class Problem055 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        //  若之前的最远跳跃距离无法到达当前位置，则false
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
