package Problem201_300;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/5/10.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
