/*
 * @lc app=leetcode id=894 lang=cpp
 *
 * [894] All Possible Full Binary Trees
 *
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 *
 * algorithms
 * Medium (79.54%)
 * Likes:    2952
 * Dislikes: 206
 * Total Accepted:    92.6K
 * Total Submissions: 116.1K
 * Testcase Example:  '7'
 *
 * Given an integer n, return a list of all possible full binary trees with n
 * nodes. Each node of each tree in the answer must have Node.val == 0.
 *
 * Each element of the answer is the root node of one possible tree. You may
 * return the final list of trees in any order.
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2
 * children.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 7
 * Output:
 * [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 *
 * Example 2:
 *
 *
 * Input: n = 3
 * Output: [[0,0,0]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 20
 *
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
  vector<TreeNode *> allPossibleFBT(int n) {
    vector<TreeNode *> fbt;
    if (n == 0) {
      return fbt;
    }
    if (n == 1) {
      fbt.emplace_back(new TreeNode(0));
      return fbt;
    }
    for (int i = 1; i < n - 1; i += 2) {
      auto left = allPossibleFBT(i);
      auto right = allPossibleFBT(n - 1 - i);
      for (int li = 0; li < left.size(); li++) {
        for (int ri = 0; ri < right.size(); ri++) {
          fbt.emplace_back(new TreeNode(0));
          fbt.back()->left = left[li];
          fbt.back()->right = right[ri];
        }
      }
    }
    return fbt;
  }
};
// @lc code=end
