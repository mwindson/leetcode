/*
 * @lc app=leetcode id=539 lang=cpp
 *
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (55.39%)
 * Likes:    1264
 * Dislikes: 225
 * Total Accepted:    108.3K
 * Total Submissions: 192.7K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Given a list of 24-hour clock time points in "HH:MM" format, return the
 * minimum minutes difference between any two time-points in the list.
 *
 * Example 1:
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 *
 *
 * Constraints:
 *
 *
 * 2 <= timePoints.length <= 2 * 10^4
 * timePoints[i] is in the format "HH:MM".
 *
 *
 */

// @lc code=start
class Solution {
public:
  int findMinDifference(vector<string> &timePoints) {
    sort(timePoints.begin(), timePoints.end());
    int min_diff = INT_MAX;
    for (int i = 0; i < timePoints.size(); i++) {
      int diff = 0;
      if (i >= 1) {
        diff = abs(timeValue(timePoints[i]) - timeValue(timePoints[i - 1]));
      } else {
        diff = abs(timeValue(timePoints[i]) -
                   timeValue(timePoints[timePoints.size() - 1]));
      }
      min_diff = min({min_diff, diff, 24 * 60 - diff});
    }
    return min_diff;
  }
  int timeValue(const string &time) {
    int hh = (time[0] - '0') * 10 + (time[1] - '0');
    int mm = (time[3] - '0') * 10 + (time[4] - '0');
    return hh * 60 + mm;
  }
};
// @lc code=end
