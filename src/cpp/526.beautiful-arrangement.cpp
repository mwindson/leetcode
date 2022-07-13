/*
 * @lc app=leetcode id=526 lang=cpp
 *
 * [526] Beautiful Arrangement
 *
 * https://leetcode.com/problems/beautiful-arrangement/description/
 *
 * algorithms
 * Medium (64.41%)
 * Likes:    2292
 * Dislikes: 300
 * Total Accepted:    134.1K
 * Total Submissions: 207.9K
 * Testcase Example:  '2'
 *
 * Suppose you have n integers labeled 1 through n. A permutation of those n
 * integers perm (1-indexed) is considered a beautiful arrangement if for every
 * i (1 <= i <= n), either of the following is true:
 *
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 *
 *
 * Given an integer n, return the number of the beautiful arrangements that you
 * can construct.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 * ⁠   - perm[1] = 1 is divisible by i = 1
 * ⁠   - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 * ⁠   - perm[1] = 2 is divisible by i = 1
 * ⁠   - i = 2 is divisible by perm[2] = 1
 *
 *
 * Example 2:
 *
 *
 * Input: n = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 15
 *
 *
 */

// @lc code=start
class Solution {
public:
  int countArrangement(int n) {
    if (n == 0) {
      return 0;
    }
    int mask = 0;
    int cnt = 0;
    int pos = 0;
    count(n, pos, cnt, mask);
    return cnt;
  }
  void count(int n, int pos, int &cnt, int mask) {
    if (pos == n) {
      cnt++;
      return;
    }
    for (int i = 1; i <= n; i++) {
      if ((mask & (1 << i)) == 0 &&
          (i % (pos + 1) == 0 || (1 + pos) % i == 0)) {
        mask |= 1 << i;
        count(n, pos + 1, cnt, mask);
        mask &= ~(1 << i);
      }
    }
  }
};
// @lc code=end
