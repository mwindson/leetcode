package Problem001_100;

/**
 * Created by mwindson on 2017/3/21.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 */
public class Problem033 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
