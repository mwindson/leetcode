/*
 * @lc app=leetcode id=347 lang=cpp
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (65.03%)
 * Likes:    9426
 * Dislikes: 377
 * Total Accepted:    995.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 *
 */

// @lc code=start
class Solution {
public:
  using Iter = unordered_map<int, int>::iterator;
  struct cmp {
    bool operator()(Iter a, Iter b) { return a->second > b->second; }
  };
  vector<int> topKFrequent(vector<int> &nums, int k) {
    unordered_map<int, int> freqCount;

    for (int num : nums) {
      freqCount[num]++;
    }
    priority_queue<Iter, vector<Iter>, cmp> q;
    for (auto it = freqCount.begin(); it != freqCount.end(); it++) {
      q.push(it);
      if (q.size() > k) {
        q.pop();
      }
    }
    vector<int> ans;
    while (!q.empty()) {
      auto top = q.top();
      ans.insert(ans.begin(), top->first);
      q.pop();
    }
    return ans;
  }
};
// @lc code=end
