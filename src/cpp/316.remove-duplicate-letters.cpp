/*
 * @lc app=leetcode id=316 lang=cpp
 *
 * [316] Remove Duplicate Letters
 *
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Medium (44.00%)
 * Likes:    5554
 * Dislikes: 364
 * Total Accepted:    200.3K
 * Total Submissions: 453.7K
 * Testcase Example:  '"bcabc"'
 *
 * Given a string s, remove duplicate letters so that every letter appears once
 * and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "bcabc"
 * Output: "abc"
 *
 *
 * Example 2:
 *
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 *
 *
 *
 * Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 */

// @lc code=start
class Solution {
public:
  string removeDuplicateLetters(string s) {
    unordered_map<char, int> last_index;
    for (int i = 0; i < s.length(); i++) {
      last_index[s[i]] = i;
    }
    unordered_map<char, bool> visited;
    stack<char> stack; // 栈依次保存字母顺序或最后一次出现的字母。

    for (int i = 0; i < s.length(); i++) {
      if (visited[s[i]]) {
        continue;
      }
      // 栈顶字符大于s[i]  且 栈顶字符非最后一次出现，则需要出栈删除。
      while (!stack.empty() && stack.top() > s[i] &&
             i < last_index[stack.top()]) {
        visited[stack.top()] = false;
        stack.pop();
      }
      stack.push(s[i]);
      visited[s[i]] = true;
    }
    string res;
    while (!stack.empty()) {
      res = stack.top() + res;
      stack.pop();
    }

    return res;
  }
};
// @lc code=end
