/*
 * @lc app=leetcode id=401 lang=cpp
 *
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (50.74%)
 * Likes:    1019
 * Dislikes: 1911
 * Total Accepted:    113.9K
 * Total Submissions: 223K
 * Testcase Example:  '1'
 *
 * A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6
 * LEDs on the bottom to represent the minutes (0-59). Each LED represents a
 * zero or one, with the least significant bit on the right.
 *
 *
 * For example, the below binary watch reads "4:51".
 *
 *
 *
 *
 * Given an integer turnedOn which represents the number of LEDs that are
 * currently on (ignoring the PM), return all possible times the watch could
 * represent. You may return the answer in any order.
 *
 * The hour must not contain a leading zero.
 *
 *
 * For example, "01:00" is not valid. It should be "1:00".
 *
 *
 * The minute must be consist of two digits and may contain a leading
 * zero.
 *
 *
 * For example, "10:2" is not valid. It should be "10:02".
 *
 *
 *
 * Example 1:
 * Input: turnedOn = 1
 * Output:
 * ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * Example 2:
 * Input: turnedOn = 9
 * Output: []
 *
 *
 * Constraints:
 *
 *
 * 0 <= turnedOn <= 10
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<string> readBinaryWatch(int turnedOn) {
    vector<string> res;
    int hour = 0;
    int min = 0;
    read(turnedOn, res, hour, min, 0);
    return res;
  }
  void read(int turnedOn, vector<string> &res, int &hour, int &min, int index) {
    if (hour >= 12 || min >= 60) {
      return;
    }
    if (turnedOn == 0) {
      string time;
      time += to_string(hour);
      time += (min < 10 ? ":0" : ":") + to_string(min);
      res.emplace_back(time);
      return;
    }
    for (int i = index; i < 10; i++) {
      if (i < 6) {
        if ((min & (1 << i)) == 0) {
          min += 1 << i;
          read(turnedOn - 1, res, hour, min, i + 1);
          min -= 1 << i;
        }
      }
      if (i >= 6) {
        if ((hour & (1 << (i - 6))) == 0) {
          hour += 1 << (i - 6);
          read(turnedOn - 1, res, hour, min, i + 1);
          hour -= 1 << (i - 6);
        }
      }
    }
  }
};
// @lc code=end
