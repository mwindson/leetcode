/*
 * @lc app=leetcode id=872 lang=cpp
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (65.00%)
 * Likes:    1946
 * Dislikes: 57
 * Total Accepted:    183K
 * Total Submissions: 280.8K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n' +
  '[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree, from left to right order, the
 * values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 =
 * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
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
  bool leafSimilar(TreeNode *root1, TreeNode *root2) {
    vector<TreeNode *> leaves1, leaves2;
    search(root1, leaves1);
    search(root2, leaves2);
    if (leaves1.size() != leaves2.size()) {
      return false;
    }
    for (int i = 0; i < leaves1.size(); i++) {
      if (leaves1[i]->val != leaves2[i]->val) {
        return false;
      }
    }
    return true;
  }
  void search(TreeNode *node, vector<TreeNode *> &leaves) {
    if (node == nullptr) {
      return;
    }
    if (node->left == nullptr && node->right == nullptr) {
      leaves.emplace_back(node);
    } else {
      if (node->left != nullptr) {
        search(node->left, leaves);
      }
      if (node->right != nullptr) {
        search(node->right, leaves);
      }
    }
  }
};
// @lc code=end
