package Problem001_100;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/9/7.
 * https://leetcode.com/problems/next-permutation
 */
public class Problem031 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
