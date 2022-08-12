/*
 * @lc app=leetcode id=524 lang=cpp
 *
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (50.94%)
 * Likes:    1432
 * Dislikes: 337
 * Total Accepted:    131.9K
 * Total Submissions: 258.1K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * Given a string s and a string array dictionary, return the longest string in
 * the dictionary that can be formed by deleting some of the given string
 * characters. If there is more than one possible result, return the longest
 * word with the smallest lexicographical order. If there is no possible
 * result, return the empty string.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 *
 *
 * Example 2:
 *
 *
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string findLongestWord(string s, vector<string> &dictionary) {
    sort(dictionary.begin(), dictionary.end(),
         [](const string &a, const string &b) {
           return a.length() > b.length() ||
                  (a.length() == b.length() && a < b);
         });
    string res;
    for (string &word : dictionary) {
      if (canForm(s, word)) {
        res = word;
        break;
      }
    }
    return res;
  }
  bool canForm(string s, string word) {
    if (s.length() < word.length()) {
      return false;
    }
    int i = 0;
    int j = 0;
    while (i < s.length() && j < word.length()) {
      if (s[i] == word[j]) {
        i++;
        j++;
      } else {
        i++;
      }
    }
    return j == word.length();
  }
};
// @lc code=end
