/*
 * @lc app=leetcode id=623 lang=cpp
 *
 * [623] Add One Row to Tree
 *
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 *
 * algorithms
 * Medium (54.03%)
 * Likes:    1419
 * Dislikes: 178
 * Total Accepted:    88.8K
 * Total Submissions: 163.8K
 * Testcase Example:  '[4,2,6,3,1,5]\n1\n2'
 *
 * Given the root of a binary tree and two integers val and depth, add a row of
 * nodes with value val at the given depth depth.
 *
 * Note that the root node is at depth 1.
 *
 * The adding rule is:
 *
 *
 * Given the integer depth, for each not null tree node cur at the depth depth
 * - 1, create two tree nodes with value val as cur's left subtree root and
 * right subtree root.
 * cur's original left subtree should be the left subtree of the new left
 * subtree root.
 * cur's original right subtree should be the right subtree of the new right
 * subtree root.
 * If depth == 1 that means there is no depth depth - 1 at all, then create a
 * tree node with value val as the new root of the whole original tree, and the
 * original tree is the new root's left subtree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,3,1,5], val = 1, depth = 2
 * Output: [4,1,1,2,null,null,6,3,1,5]
 *
 *
 * Example 2:
 *
 *
 * Input: root = [4,2,null,3,1], val = 1, depth = 3
 * Output: [4,2,null,1,1,3,null,null,1]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * The depth of the tree is in the range [1, 10^4].
 * -100 <= Node.val <= 100
 * -10^5 <= val <= 10^5
 * 1 <= depth <= the depth of tree + 1
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
  TreeNode *addOneRow(TreeNode *root, int val, int depth) {
    if (depth == 1) {
      TreeNode *new_root = new TreeNode(val);
      new_root->left = root;
      return new_root;
    }
    dfs(root, val, 1, depth);
    return root;
  }
  void dfs(TreeNode *node, int val, int curr_depth, int depth) {
    if (node == nullptr) {
      return;
    }
    if (curr_depth < depth - 1) {
      dfs(node->left, val, curr_depth + 1, depth);
      dfs(node->right, val, curr_depth + 1, depth);
      return;
    }
    auto tmp = node->left;
    node->left = new TreeNode(val);
    node->left->left = tmp;
    tmp = node->right;
    node->right = new TreeNode(val);
    node->right->right = tmp;
  }
};
// @lc code=end
