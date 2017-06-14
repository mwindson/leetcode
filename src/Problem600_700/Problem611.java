package Problem600_700;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/6/13.
 * https://leetcode.com/problems/valid-triangle-number/
 */
public class Problem611 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    count += k - j;
                    k--;
                } else
                    j++;
            }
        }
        return count;
    }
}
