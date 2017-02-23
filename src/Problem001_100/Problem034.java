package Problem001_100;

/**
 * Created by mwindson on 2017/2/22.
 * https://leetcode.com/problems/search-for-a-range/?tab=Description
 */
public class Problem034 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 9, 9, 10, 10, 10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        boolean leftStop = false;
        boolean rightStop = false;
        if (nums.length == 0)
            return range;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right && !(leftStop && rightStop)) {
            if (target > nums[left]) {
                left++;
            } else {
                leftStop = true;
            }
            if (target < nums[right]) {
                right--;
            } else {
                rightStop = true;
            }
        }
        if (left <= right) {
            range[0] = left;
            range[1] = right;
        }
        return range;
    }
}
