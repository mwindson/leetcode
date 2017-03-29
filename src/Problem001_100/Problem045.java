package Problem001_100;

/**
 * Created by mwindson on 2017/3/29.
 * https://leetcode.com/problems/jump-game-ii/#/description
 */
public class Problem045 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            current_jump_max = Math.max(current_jump_max, i + nums[i]);
            if (i == last_jump_max) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
}
