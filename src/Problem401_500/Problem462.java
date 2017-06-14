package Problem401_500;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/6/14.
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/#/description
 */
public class Problem462 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 1};
        System.out.println(minMoves2(nums));
    }

    public static int minMoves2(int[] nums) {
        // we can use quick select rather than quick sort
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
//        int median = quickselect(nums, nums.length / 2 + 1, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }

    private static int quickselect(int[] nums, int k, int start, int end) {
        int l = start, r = end, pivot = nums[(l + r) / 2];
        while (l <= r) {
            while (nums[l] < pivot) l++;
            while (nums[r] > pivot) r--;
            if (l >= r) break;
            swap(nums, l++, r--);
        }
        if (l - start + 1 > k) return quickselect(nums, k, start, l - 1);
        if (l - start + 1 == k && l == r) return nums[l];
        return quickselect(nums, k - r + start - 1, r + 1, end);
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
