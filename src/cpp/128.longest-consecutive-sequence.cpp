/*
 * @lc app=leetcode id=128 lang=cpp
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (48.77%)
 * Likes:    11848
 * Dislikes: 505
 * Total Accepted:    805.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 *
 */

// @lc code=start
class Solution {
public:
  int longestConsecutive(vector<int> &nums) {
    unordered_set<int> set(nums.begin(), nums.end());
    int longest = 0;
    for (int num : nums) {
      if (set.count(num - 1) > 0) {
        continue;
      }
      int curr = num;
      int len = 1;
      while (set.count(curr + 1) > 0) {
        curr = curr + 1;
        len += 1;
      }
      longest = max(longest, len);
    }
    return longest;
  }
};
// @lc code=end
