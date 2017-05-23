package Problem501_600;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/5/23.
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
 */
public class Problem532 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 5, 4};
        int k = 1;
        System.out.println(findPairs(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] - nums[i] == k) {
                    count++;
                    break;
                } else if (nums[middle] - nums[i] > k) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return count;
    }
}
