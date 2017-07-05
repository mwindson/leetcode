package Problem101_200;

/**
 * Created by mwindson on 2017/7/5.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/#/description
 */
public class Problem154 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 10, 10, 10};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
            }
        }
        return nums[l];
    }
}
