/*
 * @lc app=leetcode id=493 lang=cpp
 *
 * [493] Reverse Pairs
 *
 * https://leetcode.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (30.09%)
 * Likes:    3653
 * Dislikes: 200
 * Total Accepted:    98.7K
 * Total Submissions: 322.4K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * Given an integer array nums, return the number of reverse pairs in the
 * array.
 *
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] >
 * 2 * nums[j].
 *
 *
 * Example 1:
 * Input: nums = [1,3,2,3,1]
 * Output: 2
 * Example 2:
 * Input: nums = [2,4,3,5,1]
 * Output: 3
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 5 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 *
 */

// @lc code=start
class Solution {
public:
  int reversePairs(vector<int> &nums) {
    return reversePairsSub(nums, 0, nums.size() - 1);
  }
  int reversePairsSub(vector<int> &nums, int l, int r) {
    if (l >= r) {
      return 0;
    }
    int m = (r - l) / 2 + l;
    int count = 0;
    count += reversePairsSub(nums, l, m); // 计算左侧子子问题
    count += reversePairsSub(nums, m + 1, r); // 计算右侧子问题
    count += checkCount(nums, l, m, r); // 计算当前层级的pair问题

    return count;
  }

  int checkCount(vector<int> &nums, int start, int mid, int end) {

    // two pointers;
    int count = 0;
    int l = start, r = mid + 1;
    while (l <= mid && r <= end) {
      if ((long)nums[l] > (long)2 * nums[r]) {
        count += (mid - l + 1);
        r++;
      } else {
        l++;
      }
    }
    // worst case might be nlog(n)
    sort(nums.begin() + start, nums.begin() + end + 1);
    return count;

    // every step sort
  }
};
// @lc code=end
