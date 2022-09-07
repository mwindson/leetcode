/*
 * @lc app=leetcode id=687 lang=cpp
 *
 * [687] Longest Univalue Path
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Medium (39.51%)
 * Likes:    3321
 * Dislikes: 626
 * Total Accepted:    148.5K
 * Total Submissions: 373.5K
 * Testcase Example:  '[5,4,5,1,1,null,5]'
 *
 * Given the root of a binary tree, return the length of the longest path,
 * where each node in the path has the same value. This path may or may not
 * pass through the root.
 *
 * The length of the path between two nodes is represented by the number of
 * edges between them.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,5,1,1,null,5]
 * Output: 2
 * Explanation: The shown image shows that the longest path of the same value
 * (i.e. 5).
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,4,5,4,4,null,5]
 * Output: 2
 * Explanation: The shown image shows that the longest path of the same value
 * (i.e. 4).
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
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
  int longestUnivaluePath(TreeNode *root) {
    if (root == nullptr) {
      return 0;
    }
    int longest = 0;
    longestFromNode(root, longest);
    return longest;
  }
  int longestFromNode(TreeNode *node, int &longest) {
    if (node == nullptr) {
      return 0;
    }
    int left = dfs(node->left, longest);
    int right = dfs(node->right, longest);
    if (node->left && node->left->val == node->val) {
      left += 1;
    } else {
      left = 0;
    }
    if (node->right && node->right->val == node->val) {
      right += 1;
    } else {
      right = 0;
    }
    longest = max(longest, left + right);
    return max(left, right);
  }
};
// @lc code=end
