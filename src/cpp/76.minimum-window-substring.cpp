/*
 * @lc app=leetcode id=76 lang=cpp
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (39.17%)
 * Likes:    11950
 * Dislikes: 565
 * Total Accepted:    838.8K
 * Total Submissions: 2.1M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 *
 * Constraints:
 *
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

// @lc code=start
class Solution {
public:
  string minWindow(string s, string t) {
    if (t.length() > s.length()) {
      return "";
    }
    unordered_map<char, int> target_count;
    for (char c : t) {
      target_count[c]++;
    }
    string min_sub;
    int count = 0;
    int start = 0;
    int i = 0;
    while (i < s.length()) {
      if (target_count[s[i]] > 0) {
        count++; // 记录
      }
      target_count[s[i]]--;
      // 判断是否满足子串，然后滑动窗口
      if (count == t.length()) {
        // 滑动左侧指针
        while (start < i && target_count[s[start]] < 0) {
          target_count[s[start]]++;
          start++;
        }
        cout << start << " " << i << endl;
        if (i - start + 1 < min_sub.length() || min_sub.empty()) {
          min_sub = s.substr(start, i - start + 1);
        }
        target_count[s[start]]++;
        start++;
        count--;
      }
      i++;
    }

    return min_sub;
  }
};
// @lc code=end
