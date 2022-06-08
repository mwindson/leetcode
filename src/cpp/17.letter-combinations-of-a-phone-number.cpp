/*
 * @lc app=leetcode id=17 lang=cpp
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (54.44%)
 * Likes:    10830
 * Dislikes: 704
 * Total Accepted:    1.2M
 * Total Submissions: 2.3M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 *
 * Example 2:
 *
 *
 * Input: digits = ""
 * Output: []
 *
 *
 * Example 3:
 *
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<string> letterCombinations(string digits) {
    vector<string> res;
    if (digits.length() == 0) {
      return res;
    }
    combine(res, "", digits, 0);
    return res;
  }
  void combine(vector<string> &res, string curr, string digits, int start) {
    if (start == digits.length()) {
      res.emplace_back(curr);
      return;
    }
    vector<char> value{};
    if (keyboard_.count(digits[start]) > 0) {
      value = keyboard_[digits[start]];
    }
    for (int i = 0; i < value.size(); i++) {
      curr += value[i];
      combine(res, curr, digits, start + 1);
      curr = curr.substr(0, curr.length() - 1);
    }
  }

private:
  unordered_map<char, vector<char>> keyboard_{
      {'2', {'a', 'b', 'c'}}, {'3', {'d', 'e', 'f'}},
      {'4', {'g', 'h', 'i'}}, {'5', {'j', 'k', 'l'}},
      {'6', {'m', 'n', 'o'}}, {'7', {'p', 'q', 'r', 's'}},
      {'8', {'t', 'u', 'v'}}, {'9', {'w', 'x', 'y', 'z'}}};
};
// @lc code=end
