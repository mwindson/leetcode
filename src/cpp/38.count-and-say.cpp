/*
 * @lc app=leetcode id=38 lang=cpp
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Medium (48.87%)
 * Likes:    1861
 * Dislikes: 4266
 * Total Accepted:    660.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula:
 *
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from
 * countAndSay(n-1), which is then converted into a different digit string.
 *
 *
 * To determine how you "say" a digit string, split it into the minimal number
 * of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit.
 * Finally, concatenate every said digit.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 * Given a positive integer n, return the n^th term of the count-and-say
 * sequence.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 30
 *
 *
 */

// @lc code=start
class Solution {
public:
  string countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    string prev = countAndSay(n - 1);
    int cnt = 0;
    int num = -1;
    string next;
    for (int i = 0; i < prev.length(); i++) {
      int curr = prev[i] - '0';
      if (num == -1) {
        num = curr;
        cnt = 1;
      } else if (num != curr) {
        next += to_string(cnt) + to_string(num);
        num = curr;
        cnt = 1;
      } else {
        cnt++;
      }
    }
    if (num != -1 && cnt > 0) {
      next += to_string(cnt) + to_string(num);
    }
    return next;
  }
};
// @lc code=end
