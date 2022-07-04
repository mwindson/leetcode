/*
 * @lc app=leetcode id=105 lang=cpp
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (58.03%)
 * Likes:    8677
 * Dislikes: 236
 * Total Accepted:    722.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 *
 * Example 2:
 *
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
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
  TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    return buildPart(preorder, 0, preorder.size() - 1, inorder, 0,
                     inorder.size() - 1);
  }
  TreeNode *buildPart(vector<int> &preorder, int i, int j, vector<int> &inorder,
                      int a, int b) {
    if (i > j || a > b) {
      return nullptr;
    }
    int num = preorder[i];
    int index = 0;
    for (; a + index <= b; index++) {
      if (inorder[a + index] == num) {
        break;
      }
    }
    TreeNode *node = new TreeNode(num);
    node->left =
        buildPart(preorder, i + 1, i + index, inorder, a, a + index - 1);
    node->right =
        buildPart(preorder, i + index + 1, j, inorder, a + index + 1, b);
    return node;
  }
};
// @lc code=end
