package Problem101_200;

/**
 * Created by mwindson on 2017/3/21.
 * https://leetcode.com/problems/maximum-product-subarray/#/description
 */
public class Problem152 {
    public static void main(String[] args) {
        int[] nums = {-2, -1, 4, -1, 1, 2, -3, 1};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxPre = nums[0];
        int minPre = nums[0];
        int maxSofar = nums[0];
        int maxCurr, minCurr;

        for (int i = 1; i < nums.length; i++) {
            maxCurr = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
            minCurr = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
            maxSofar = Math.max(maxCurr, maxSofar);
            maxPre = maxCurr;
            minPre = minCurr;
        }
        return maxSofar;
    }
}
