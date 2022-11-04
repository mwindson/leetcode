/*
 * @lc app=leetcode id=257 lang=cpp
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (58.98%)
 * Likes:    5093
 * Dislikes: 217
 * Total Accepted:    572.9K
 * Total Submissions: 945.8K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any
 * order.
 *
 * A leaf is a node with no children.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 100].
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
  vector<string> binaryTreePaths(TreeNode *root) {
    vector<string> paths;
    search(root, paths, "");
    return paths;
  }
  void search(TreeNode *node, vector<string> &paths, string prev) {
    if (node == nullptr) {
      return;
    }
    if (node->left == nullptr && node->right == nullptr) {
      string path = append(prev, node->val);
      paths.emplace_back(path);
      return;
    }
    if (node->left != nullptr) {
      search(node->left, paths, append(prev, node->val));
    }
    if (node->right != nullptr) {
      search(node->right, paths, append(prev, node->val));
    }
  }
  string append(string s, int val) {
    if (s.empty()) {
      return to_string(val);
    }
    return s + "->" + to_string(val);
  }
};
// @lc code=end
