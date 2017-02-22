package Problem001_100;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/2/17.
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Problem041 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 6};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int firstPosIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                firstPosIndex = i;
                break;
            }
        }
        int m = firstPosIndex;
        int n = 1;
        int firstMissingPositive = -1;
        while (m < nums.length) {
            if (nums[m] != n) {
                firstMissingPositive = n;
                break;
            }
            if ((m < nums.length - 1 && nums[m] != nums[m + 1]) || m == nums.length - 1) {
                n++;
            }
            m++;
        }
        if (firstMissingPositive == -1)
            firstMissingPositive = n;
        return firstMissingPositive;
    }
}
