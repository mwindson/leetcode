/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (39.63%)
 * Likes:    9664
 * Dislikes: 3288
 * Total Accepted:    1.8M
 * Total Submissions: 4.4M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 * Example 1:
 *
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string longestCommonPrefix(vector<string> &strs) {
    if (strs.size() == 0) {
      return "";
    }
    int prefix_len = 0; // prefix 在strs[0]的 长度
    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0][i];
      bool is_prefix = true;
      for (int j = 1; j < strs.size(); j++) {
        if (strs[j].length() <= i || strs[j][i] != c) {
          is_prefix = false;
          break;
        }
      }
      if (is_prefix) {
        prefix_len++;
      } else {
        break;
      }
    }
    return strs[0].substr(0, prefix_len);
  }
};
// @lc code=end
