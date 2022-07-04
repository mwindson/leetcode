/*
 * @lc app=leetcode id=125 lang=cpp
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (42.02%)
 * Likes:    3959
 * Dislikes: 5416
 * Total Accepted:    1.3M
 * Total Submissions: 3.2M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 *
 * Example 3:
 *
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool isPalindrome(string s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (!isCharacter(s[left]) && !isDigit(s[left])) {
        left++;
        continue;
      }
      if (!isCharacter(s[right]) && !isDigit(s[right])) {
        right--;
        continue;
      }
      if (lower(s[left]) != lower(s[right])) {
        cout << s[left] << " " << s[right] << endl;
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  int lower(char c) {
    if (c >= 'A' && c <= 'Z') {
      return c - 'A' + 'a';
    }
    return c;
  }
  bool isCharacter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
  bool isDigit(char c) { return c >= '0' && c <= '9'; }
};
// @lc code=end
