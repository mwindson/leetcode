/*
 * @lc app=leetcode id=508 lang=cpp
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (63.07%)
 * Likes:    1711
 * Dislikes: 259
 * Total Accepted:    116.6K
 * Total Submissions: 182.3K
 * Testcase Example:  '[5,2,-3]'
 *
 * Given the root of a binary tree, return the most frequent subtree sum. If
 * there is a tie, return all the values with the highest frequency in any
 * order.
 *
 * The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself).
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,2,-3]
 * Output: [2,-3,4]
 *
 *
 * Example 2:
 *
 *
 * Input: root = [5,2,-5]
 * Output: [2]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
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
  vector<int> findFrequentTreeSum(TreeNode *root) {
    unordered_map<int, int> map;
    int max_cnt = 0;
    computeSum(root, map, max_cnt);

    vector<int> res;
    for (auto &pair : map) {
      if (pair.second == max_cnt) {
        res.emplace_back(pair.first);
      }
    }
    return res;
  }
  int computeSum(TreeNode *root, unordered_map<int, int> &map, int &max_cnt) {
    if (root == nullptr) {
      return 0;
    }
    int left = computeSum(root->left, map, max_cnt);
    int right = computeSum(root->right, map, max_cnt);
    int sum = root->val + left + right;
    map[sum]++;
    max_cnt = max(max_cnt, map[sum]);
    return sum;
  }
};
// @lc code=end
