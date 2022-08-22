/*
 * @lc app=leetcode id=119 lang=cpp
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (57.90%)
 * Likes:    3023
 * Dislikes: 276
 * Total Accepted:    575.2K
 * Total Submissions: 975.9K
 * Testcase Example:  '3'
 *
 * Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the
 * Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 *
 * 0 <= rowIndex <= 33
 *
 *
 *
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> getRow(int rowIndex) {
    vector<int> ans;
    for (int i = 0; i < rowIndex + 1; i++) {
      if (i == 0) {
        ans.push_back(1);
      } else if (i > rowIndex / 2) {
        ans.push_back(ans[rowIndex - i]);
      } else {
        ans.push_back((long)ans[i - 1] * (rowIndex + 1 - i) / (i));
      }
    }
    return ans;
  }
};
// @lc code=end
