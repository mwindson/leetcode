/*
 * @lc app=leetcode id=395 lang=cpp
 *
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (44.63%)
 * Likes:    4453
 * Dislikes: 366
 * Total Accepted:    168.3K
 * Total Submissions: 375.9K
 * Testcase Example:  '"aaabb"\n3'
 *
 * Given a string s and an integer k, return the length of the longest
 * substring of s such that the frequency of each character in this substring
 * is greater than or equal to k.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times
 * and 'b' is repeated 3 times.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^5
 *
 *
 */

// @lc code=start
class Solution {
public:
  int longestSubstring(string s, int k) {
    return findSub(s, 0, s.length() - 1, k);
  }
  int findSub(const string &s, int start, int end, int k) {
    if (start > end || k > end - start + 1) {
      return 0;
    }
    if (k == 0) {
      return end - start + 1;
    }
    unordered_map<char, int> map;
    for (int i = start; i <= end; i++) {
      map[s[i]]++;
    }
    int index = start;
    while (index <= end && map[s[index]] >= k) {
      index++;
    }
    if (index > end) {
      return end - start + 1;
    }
    int left = findSub(s, start, index - 1, k);
    int right = findSub(s, index + 1, end, k);
    return max(left, right);
  }
};
// @lc code=end
