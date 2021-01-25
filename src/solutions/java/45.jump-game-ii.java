/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int cnt = 0, furthest = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, nums[i] + i);
            if (i == end) {
                cnt++;
                end = furthest;
            }
        }
        return cnt;
    }
}
// @lc code=end
