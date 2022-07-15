/*
 * @lc app=leetcode id=106 lang=cpp
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (55.68%)
 * Likes:    4867
 * Dislikes: 76
 * Total Accepted:    417K
 * Total Submissions: 740.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 *
 * Example 2:
 *
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
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
  TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
    return build(inorder, 0, inorder.size() - 1, postorder, 0,
                 postorder.size() - 1);
  }
  TreeNode *build(vector<int> &inorder, int m, int n, vector<int> &postorder,
                  int a, int b) {
    if (m > n || a > b) {
      return nullptr;
    }
    int nodeVal = postorder[b];
    TreeNode *node = new TreeNode(nodeVal);
    int leftLen = -1;
    for (int i = m; i <= n; i++) {
      if (inorder[i] == nodeVal) {
        leftLen = i - m;
        break;
      }
    }
    node->left =
        build(inorder, m, m + leftLen - 1, postorder, a, a + leftLen - 1);
    node->right =
        build(inorder, m + leftLen + 1, n, postorder, a + leftLen, b - 1);
    return node;
  }
};
// @lc code=end
