/*
 * @lc app=leetcode id=110 lang=cpp
 *
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (47.01%)
 * Likes:    6487
 * Dislikes: 341
 * Total Accepted:    834.9K
 * Total Submissions: 1.8M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 *
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 *
 * Example 3:
 *
 *
 * Input: root = []
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
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
  bool isBalanced(TreeNode *root) {
    bool isBalanced = false;
    calHeight(root, isBalanced);
    return isBalanced;
  }

  int calHeight(TreeNode *node, bool &isBalanced) {
    if (node == nullptr) {
      isBalanced = true;
      return 0;
    }
    bool leftBalanced = false;
    bool rightBalanced = false;
    int leftHeight = calHeight(node->left, leftBalanced);
    int rightHeight = calHeight(node->right, rightBalanced);
    isBalanced =
        leftHeight - rightHeight <= 1 && leftHeight - rightHeight >= -1;
    isBalanced = isBalanced && leftBalanced && rightBalanced;
    return max(leftHeight, rightHeight) + 1;
  }
};
// @lc code=end
