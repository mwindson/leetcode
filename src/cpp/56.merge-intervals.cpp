/*
 * @lc app=leetcode id=56 lang=cpp
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (45.10%)
 * Likes:    14359
 * Dislikes: 538
 * Total Accepted:    1.5M
 * Total Submissions: 3.3M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 *
 *
 * Example 1:
 *
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into
 * [1,6].
 *
 *
 * Example 2:
 *
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> merge(vector<vector<int>> &intervals) {
    vector<vector<int>> ans;
    if (intervals.size() == 0) {
      return ans;
    }
    sort(intervals.begin(), intervals.end(),
         [](const vector<int> &a, const vector<int> &b) {
           return a[0] < b[0] || (a[0] == b[0] && a[1] < b[1]);
         });
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.size(); i++) {
      const auto &interval = intervals[i];
      if (interval[0] > end) {
        ans.emplace_back(vector<int>{start, end});
        start = interval[0];
        end = interval[1];
      } else {
        end = max(end, interval[1]);
      }
    }
    ans.emplace_back(vector<int>{start, end});
    return ans;
  }
};
// @lc code=end
