/*
 * @lc app=leetcode id=77 lang=cpp
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (64.36%)
 * Likes:    4298
 * Dislikes: 150
 * Total Accepted:    534K
 * Total Submissions: 829.4K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> combine(int n, int k) {
    vector<vector<int>> res;
    vector<int> vec;
    combineOnce(res, vec, 1, n, k);
    return res;
  }
  void combineOnce(vector<vector<int>> &res, vector<int> &curr, int start,
                   int n, int k) {
    if (curr.size() == k) {
      res.emplace_back(curr);
      return;
    }
    for (int i = start; i <= n; i++) {
      curr.emplace_back(i);
      combineOnce(res, curr, i + 1, n, k);
      curr.pop_back();
    }
  }
};
// @lc code=end
