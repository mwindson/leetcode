/*
 * @lc app=leetcode id=692 lang=cpp
 *
 * [692] Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (54.47%)
 * Likes:    4530
 * Dislikes: 253
 * Total Accepted:    386K
 * Total Submissions: 708.6K
 * Testcase Example:  '["i","love","leetcode","i","love","coding"]\n2'
 *
 * Given an array of strings words and an integer k, return the k most frequent
 * strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the
 * words with the same frequency by their lexicographical order.
 *
 *
 * Example 1:
 *
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 *
 * Example 2:
 *
 *
 * Input: words =
 * ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent
 * words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 *
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 *
 */

// @lc code=start
class Solution {
public:
  using Iter = unordered_map<string, int>::iterator;
  struct cmp {
    bool operator()(Iter a, Iter b) {
      return a->second > b->second ||
             (a->second == b->second && a->first < b->first);
    };
  };
  vector<string> topKFrequent(vector<string> &words, int k) {
    unordered_map<string, int> freqCount;
    for (const auto &word : words) {
      freqCount[word]++;
    }
    std::priority_queue<Iter, vector<Iter>, cmp> q;
    for (auto it = freqCount.begin(); it != freqCount.end(); it++) {
      q.push(it);
      if (q.size() > k) {
        q.pop();
      }
    }
    vector<string> ans;
    while (!q.empty()) {
      auto top = q.top();
      ans.insert(ans.begin(), top->first);
      q.pop();
    }
    return ans;
  }
};
// @lc code=end
