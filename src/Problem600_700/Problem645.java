package Problem600_700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/8/2.
 * https://leetcode.com/problems/set-mismatch/description/
 */
public class Problem645 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5, 5};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0)
                res[0] = Math.abs(i);
            else
                nums[Math.abs(i) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) res[1] = i + 1;
        return res;
    }
}
