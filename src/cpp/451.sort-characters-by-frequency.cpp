/*
 * @lc app=leetcode id=451 lang=cpp
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (67.91%)
 * Likes:    5074
 * Dislikes: 196
 * Total Accepted:    408.8K
 * Total Submissions: 595.9K
 * Testcase Example:  '"tree"'
 *
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears
 * in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of
 * them.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and
 * "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 5 * 10^5
 * s consists of uppercase and lowercase English letters and digits.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string frequencySort(string s) {
    unordered_map<char, int> map;
    for (char c : s) {
      map[c]++;
    }
    vector<pair<char, int>> pairs;
    for (auto &p : map) {
      pairs.emplace_back(p);
    }
    sort(pairs.begin(), pairs.end(),
         [](const pair<char, int> &a, const pair<char, int> &b) {
           return a.second > b.second ||
                  (a.second == b.second && a.first < b.first);
         });
    string res;
    for (const auto &p : pairs) {
      for (int i = 0; i < p.second; i++) {
        res += p.first;
      }
    }
    return res;
  }
};
// @lc code=end
