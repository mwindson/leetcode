package Problem501_600;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/5/24.
 * https://leetcode.com/problems/array-partition-i/#/description
 */
public class Problem561 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
