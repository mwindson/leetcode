/*
 * @lc app=leetcode id=662 lang=cpp
 *
 * [662] Maximum Width of Binary Tree
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (40.29%)
 * Likes:    5496
 * Dislikes: 798
 * Total Accepted:    214.1K
 * Total Submissions: 529.1K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given the root of a binary tree, return the maximum width of the given
 * tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and rightmost non-null nodes), where the null nodes between the
 * end-nodes that would be present in a complete binary tree extending down to
 * that level are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of a 32-bit signed
 * integer.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width exists in the third level with length 4
 * (5,3,null,9).
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7
 * (6,null,null,null,null,null,7).
 *
 *
 * Example 3:
 *
 *
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width exists in the second level with length 2
 * (3,2).
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 3000].
 * -100 <= Node.val <= 100
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
  int widthOfBinaryTree(TreeNode *root) {
    if (!root)
      return 0;
    uint64_t max = 0;
    queue<pair<TreeNode *, uint64_t>> q;
    q.push(pair<TreeNode *, uint64_t>(root, 1));
    while (!q.empty()) {
      uint64_t l = q.front().second, r = l; // right started same as left
      for (int i = 0, n = q.size(); i < n; i++) {
        TreeNode *node = q.front().first;
        r = q.front().second;
        q.pop();
        if (node->left)
          q.push({node->left, r * 2});
        if (node->right)
          q.push({node->right, r * 2 + 1});
      }
      max = std::max(max, r + 1 - l);
    }
    return max;
  }
};
// @lc code=end
