/*
 * @lc app=leetcode id=139 lang=cpp
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (44.70%)
 * Likes:    10750
 * Dislikes: 469
 * Total Accepted:    1.1M
 * Total Submissions: 2.5M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary
 * words.
 *
 * Note that the same word in the dictionary may be reused multiple times in
 * the segmentation.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 *
 *
 * Example 2:
 *
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool wordBreak(string s, vector<string> &wordDict) {
    if (s.length() == 0) {
      return true;
    }
    unordered_set<string> dict;
    for (const auto &word : wordDict) {
      dict.insert(word);
    }
    vector<bool> canBreak(s.length() + 1, false);
    canBreak[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (canBreak[j]) {
          string word = s.substr(j, i - j);
          if (dict.find(word) != dict.end()) {
            canBreak[i] = true;
            break; // next i
          }
        }
      }
    }
    return canBreak[s.length()];
  }
};
// @lc code=end
