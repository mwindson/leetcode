/*
 * @lc app=leetcode id=513 lang=cpp
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (65.42%)
 * Likes:    2473
 * Dislikes: 232
 * Total Accepted:    189.3K
 * Total Submissions: 286.3K
 * Testcase Example:  '[2,1,3]'
 *
 * Given the root of a binary tree, return the leftmost value in the last row
 * of the tree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
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
  // BFS可以用层序遍历
  int findBottomLeftValue(TreeNode *root) {
    if (root == nullptr) {
      return 0;
    }
    deque<TreeNode *> q;
    q.push_back(root);
    int val = 0;
    while (!q.empty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        auto n = q.front();
        q.pop_front();
        if (i == 0) {
          val = n->val;
        }
        if (n->left) {
          q.push_back(n->left);
        }
        if (n->right) {
          q.push_back(n->right);
        }
      }
    }
    return val;
  }
};
// @lc code=end
