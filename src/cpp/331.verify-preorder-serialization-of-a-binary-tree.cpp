/*
 * @lc app=leetcode id=331 lang=cpp
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 *
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (43.80%)
 * Likes:    1854
 * Dislikes: 93
 * Total Accepted:    119.6K
 * Total Submissions: 271.4K
 * Testcase Example:  '"9,3,4,#,#,1,#,#,2,#,6,#,#"'
 *
 * One way to serialize a binary tree is to use preorder traversal. When we
 * encounter a non-null node, we record the node's value. If it is a null node,
 * we record using a sentinel value such as '#'.
 *
 * For example, the above binary tree can be serialized to the string
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
 *
 * Given a string of comma-separated values preorder, return true if it is a
 * correct preorder traversal serialization of a binary tree.
 *
 * It is guaranteed that each comma-separated value in the string must be
 * either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid.
 *
 *
 * For example, it could never contain two consecutive commas, such as
 * "1,,3".
 *
 *
 * Note: You are not allowed to reconstruct the tree.
 *
 *
 * Example 1:
 * Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 * Input: preorder = "1,#"
 * Output: false
 * Example 3:
 * Input: preorder = "9,#,#,1"
 * Output: false
 *
 *
 * Constraints:
 *
 *
 * 1 <= preorder.length <= 10^4
 * preorder consist of integers in the range [0, 100] and '#' separated by
 * commas ','.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool isValidSerialization(string preorder) {
    stack<char> stack;
    int start = -1;
    preorder += ",";
    for (int i = 0; i < preorder.length(); i++) {
      if (preorder[i] == ',') {
        if (start >= 0) {
          stack.push('!');
          start = -1;
        }
      } else if (preorder[i] == '#') {
        while (!stack.empty() && stack.top() == '#') {
          stack.pop();
          if (!stack.empty() && stack.top() == '!') {
            stack.pop();
          } else {
            return false;
          }
        }
        stack.push('#');
      } else {
        if (start == -1) {
          start = i;
        }
      }
    }
    return stack.size() == 1 && stack.top() == '#';
  }
};
// @lc code=end
