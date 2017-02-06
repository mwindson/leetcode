package Problem001_100;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by mwindson on 2017/2/6.
 * https://leetcode.com/problems/3sum-closest/
 */
public class Problem016 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumClosest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    sumClosest = target;
                    break;
                } else if (sum < target) {
                    if (Math.abs(sum - target) < Math.abs(sumClosest - target)) {
                        sumClosest = sum;
                    }
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    left++;
                } else {
                    if (Math.abs(sum - target) < Math.abs(sumClosest - target)) {
                        sumClosest = sum;
                    }
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    right--;
                }
            }
        }
        return sumClosest;
    }
}
