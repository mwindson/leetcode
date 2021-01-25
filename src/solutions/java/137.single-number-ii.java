/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            int bit = 1 << i;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    cnt++;
                }
            }
            // 不等于0说明唯一出现的数字在这个 bit 上是1
            if (cnt % 3 != 0) {
                res = res | bit;
            }
        }
        return res;
    }
}
// @lc code=end
