package Problem101_200;

/**
 * Created by mwindson on 2017/7/5.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 */
public class Problem153 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[0];
        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (nums[middle] >= nums[left]) {
                left = middle + 1;
                if (nums[middle] > nums[middle + 1]) break;
            } else {
                right = middle - 1;
                if (nums[middle] < nums[middle - 1]) {
                    left = middle;
                    break;
                }
            }
        }
        return nums[left];
    }
}
