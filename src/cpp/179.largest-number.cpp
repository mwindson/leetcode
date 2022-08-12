/*
 * @lc app=leetcode id=179 lang=cpp
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (33.10%)
 * Likes:    5467
 * Dislikes: 455
 * Total Accepted:    339.3K
 * Total Submissions: 1M
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non-negative integers nums, arrange them such that they form
 * the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead
 * of an integer.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [10,2]
 * Output: "210"
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 *
 *
 */

// @lc code=start
class Solution {
public:
  string largestNumber(vector<int> &nums) {
    sort(nums.begin(), nums.end(), [](int a, int b) {
      string s1 = to_string(a);
      string s2 = to_string(b);
      int i = 0;
      int max_len = s1.length() + s2.length();
      while (i < max_len) {
        char c1 = s1[i % s1.length()];
        char c2 = s2[i % s2.length()];
        if (c1 < c2) {
          return false;
        } else if (c1 > c2) {
          return true;
        }
        i++;
      }
      return false;
    });
    string res;
    for (int num : nums) {
      if (res == "0") {
        break;
      }
      res += to_string(num);
    }
    return res;
  }
};
// @lc code=end
