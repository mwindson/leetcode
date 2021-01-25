/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }
        int bit = 1;
        while ((xor & bit) == 0) {
            bit <<= 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bit) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
            if (((i + 1) & bit) == 0) {
                a ^= i + 1;
            } else {
                b ^= i + 1;
            }

        }
        for (int num : nums) {
            if (a == num) {
                return new int[] { a, b };
            }
        }
        return new int[] { b, a };
    }
}
// @lc code=end
