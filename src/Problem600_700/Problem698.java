package Problem600_700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/11/16.
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 */
public class Problem698 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }


    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (k <= 0 || sum % k != 0) return false;
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return divideSubsets(nums, visited, 0, k, 0, 0, target);
    }


    public static boolean divideSubsets(int[] nums, boolean[] visited, int index, int k, int curSum, int curNum, int target) {
        if (k == 1) return true;
        if (curSum == target && curNum > 0) return divideSubsets(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (divideSubsets(nums, visited, i + 1, k, curSum + nums[i], curNum + 1, target)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
