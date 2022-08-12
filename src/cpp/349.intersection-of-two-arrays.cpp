/*
 * @lc app=leetcode id=349 lang=cpp
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (69.27%)
 * Likes:    3376
 * Dislikes: 1971
 * Total Accepted:    715.8K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return
 * the result in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 *
 * Example 2:
 *
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> intersection(vector<int> &nums1, vector<int> &nums2) {
    unordered_map<int, int> inter;
    for (int num : nums1) {
      inter[num] = 1;
    }
    for (int num : nums2) {
      if (inter.count(num) > 0 && inter[num] == 1) {
        inter[num] = 0;
      }
    }
    vector<int> res;
    for (auto it = inter.begin(); it != inter.end(); it++) {
      if (it->second == 0) {
        res.emplace_back(it->first);
      }
    }
    return res;
  }
};
// @lc code=end
