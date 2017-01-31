package Problem001_100;

/**
 * Created by mwindson on 2017/1/31.
 * Question: https://leetcode.com/problems/search-insert-position/
 */
public class Problem035 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                break;
            } else {
                if (nums[mid] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return left;
    }
}
