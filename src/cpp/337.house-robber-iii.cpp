/*
 * @lc app=leetcode id=337 lang=cpp
 *
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (53.59%)
 * Likes:    6357
 * Dislikes: 97
 * Total Accepted:    292.4K
 * Total Submissions: 545.4K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a
 * tour, the smart thief realized that all houses in this place form a binary
 * tree. It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 *
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * 0 <= Node.val <= 10^4
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
  int rob(TreeNode *root) {
    if (root == nullptr) {
      return 0;
    }
    unordered_map<int, int> robbedMap;
    unordered_map<int, int> unrobbedMap;
    return solve(root, false, 0u, robbedMap, unrobbedMap);
  }
  int solve(TreeNode *node, bool robbed, long index,
            unordered_map<int, int> &robbedMap,
            unordered_map<int, int> &unrobbedMap) {
    if (node == nullptr) {
      return 0;
    }
    int unrobbedSum = 0;
    if (unrobbedMap.count(index) > 0) {
      unrobbedSum = unrobbedMap[index];
    } else {
      unrobbedSum =
          solve(node->left, false, index * 2 + 1, robbedMap, unrobbedMap) +
          solve(node->right, false, index * 2 + 2, robbedMap, unrobbedMap);
      unrobbedMap[index] = unrobbedSum;
    }

    if (robbed) {
      return unrobbedSum;
    }
    int robbedSum = 0;
    if (robbedMap.count(index) > 0) {
      robbedSum = robbedMap[index];
    } else {
      robbedSum =
          solve(node->left, true, index * 2 + 1, robbedMap, unrobbedMap) +
          solve(node->right, true, index * 2 + 2, robbedMap, unrobbedMap) +
          node->val;
      robbedMap[index] = robbedSum;
    }

    return max(unrobbedSum, robbedSum);
  }
};
// @lc code=end
