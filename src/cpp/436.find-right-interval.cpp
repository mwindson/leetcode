/*
 * @lc app=leetcode id=436 lang=cpp
 *
 * [436] Find Right Interval
 *
 * https://leetcode.com/problems/find-right-interval/description/
 *
 * algorithms
 * Medium (49.79%)
 * Likes:    1393
 * Dislikes: 270
 * Total Accepted:    83.7K
 * Total Submissions: 166.8K
 * Testcase Example:  '[[1,2]]'
 *
 * You are given an array of intervals, where intervals[i] = [starti, endi] and
 * each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >=
 * endi and startj is minimized. Note that i may equal j.
 *
 * Return an array of right interval indices for each interval i. If no right
 * interval exists for interval i, then put -1 at index i.
 *
 *
 * Example 1:
 *
 *
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs
 * -1.
 *
 *
 * Example 2:
 *
 *
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start
 * that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start
 * that is >= end2 = 2.
 *
 *
 * Example 3:
 *
 *
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start
 * that is >= end1 = 3.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= intervals.length <= 2 * 10^4
 * intervals[i].length == 2
 * -10^6 <= starti <= endi <= 10^6
 * The start point of each interval is unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> findRightInterval(vector<vector<int>> &intervals) {
    // 1,4
    // 2,3
    // 3,4
    vector<int> indices;
    for (int i = 0; i < intervals.size(); i++) {
      indices.emplace_back(i);
    }
    sort(indices.begin(), indices.end(), [&intervals](int i, int j) {
      return intervals[i][0] < intervals[j][0] ||
             (intervals[i][0] == intervals[j][0] &&
              intervals[i][1] < intervals[j][1]);
    });
    vector<int> res;
    for (int i = 0; i < intervals.size(); i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];
      int index = findRight(end, indices, intervals);
      if (index >= indices.size()) {
        res.emplace_back(-1);
      } else {
        res.emplace_back(indices[index]);
      }
    };
    return res;
  }
  int findRight(int end, const vector<int> &indices,
                const vector<vector<int>> &intervals) {
    int l = 0;
    int r = indices.size() - 1;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      int index = indices[mid];
      if (intervals[index][0] >= end) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
};
// @lc code=end
