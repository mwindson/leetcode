/*
 * @lc app=leetcode id=30 lang=cpp
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (28.26%)
 * Likes:    320
 * Dislikes: 20
 * Total Accepted:    321.4K
 * Total Submissions: 1M
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string s and an array of strings words. All the strings of
 * words are of the same length.
 *
 * A concatenated substring in s is a substring that contains all the strings
 * of any permutation of words concatenated.
 *
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef",
 * "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is
 * not a concatenated substring because it is not the concatenation of any
 * permutation of words.
 *
 *
 * Return the starting indices of all the concatenated substrings in s. You can
 * return the answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the
 * concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation of
 * ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of
 * ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation: Since words.length == 4 and words[i].length == 4, the
 * concatenated substring has to be of length 16.
 * There is no substring of length 16 is s that is equal to the concatenation
 * of any permutation of words.
 * We return an empty array.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation: Since words.length == 3 and words[i].length == 3, the
 * concatenated substring has to be of length 9.
 * The substring starting at 6 is "foobarthe". It is the concatenation of
 * ["foo","bar","the"] which is a permutation of words.
 * The substring starting at 9 is "barthefoo". It is the concatenation of
 * ["bar","the","foo"] which is a permutation of words.
 * The substring starting at 12 is "thefoobar". It is the concatenation of
 * ["the","foo","bar"] which is a permutation of words.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * s and words[i] consist of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> findSubstring(string s, vector<string> &words) {
    unordered_map<string, int> map;
    int total = 0;
    int len = 0;
    for (const auto &word : words) {
      total += word.length();
      len = word.length();
      map[word]++;
    }

    vector<int> res;
    if (total > s.length()) {
      return res;
    }

    vector<unordered_map<string, int>> maps(len, map);
    vector<int> lefts(len, 0);
    vector<int> rights(len, 0);
    for (int i = 0; i < len; i++) {
      lefts[i] = i;
      rights[i] = i;
      while (rights[i] < total) {
        string str = s.substr(rights[i], len);
        maps[i][str]--;
        if (maps[i][str] == 0) {
          maps[i].erase(str);
        }
        rights[i] += len;
      }
      if (maps[i].empty()) {
        res.emplace_back(lefts[i]);
      }
      while (rights[i] + len - 1 < s.length()) {
        string s1 = s.substr(lefts[i], len);
        string s2 = s.substr(rights[i], len);
        maps[i][s1]++;
        maps[i][s2]--;
        if (maps[i][s1] == 0) {
          maps[i].erase(s1);
        }
        if (maps[i][s2] == 0) {
          maps[i].erase(s2);
        }
        lefts[i] += len;
        rights[i] += len;
        if (maps[i].empty()) {
          res.emplace_back(lefts[i]);
        }
      }
    }
    return res;
  }
};
// @lc code=end
