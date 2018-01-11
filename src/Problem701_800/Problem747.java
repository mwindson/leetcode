package Problem701_800;

import Util.Interval;

/**
 * Created by mwindson on 2018/1/10.
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 */
public class Problem747 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 8};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex) {
                if (max < nums[i] * 2) {
                    return -1;
                }
            }
        }
        return maxIndex;
    }
}
