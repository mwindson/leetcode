package Problem600_700;

/**
 * Created by mwindson on 2017/9/14.
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class Problem674 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) res = Math.max(res, ++cnt);
            else cnt = 1;
        }
        return res;

    }
}
