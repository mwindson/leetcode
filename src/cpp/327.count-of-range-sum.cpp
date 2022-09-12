/*
 * @lc app=leetcode id=327 lang=cpp
 *
 * [327] Count of Range Sum
 *
 * https://leetcode.com/problems/count-of-range-sum/description/
 *
 * algorithms
 * Hard (36.08%)
 * Likes:    1759
 * Dislikes: 185
 * Total Accepted:    63.4K
 * Total Submissions: 175.9K
 * Testcase Example:  '[-2,5,-1]\n-2\n2'
 *
 * Given an integer array nums and two integers lower and upper, return the
 * number of range sums that lie in [lower, upper] inclusive.
 *
 * Range sum S(i, j) is defined as the sum of the elements in nums between
 * indices i and j inclusive, where i <= j.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2
 * Output: 3
 * Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their
 * respective sums are: -2, -1, 2.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0], lower = 0, upper = 0
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * -10^5 <= lower <= upper <= 10^5
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int countRangeSum(vector<int> &nums, int lower, int upper) {
    if (nums.size() == 0) {
      return 0;
    }
    sort(nums.begin(), nums.end());
    vector<long> sum(nums.size() + 1, 0);
    sum[0] = 0;
    sum[1] = nums[0];
    for (int i = 1; i <= nums.size(); i++) {
      sum[i] = sum[i - 1] + nums[i - 1];
    }
    int count = 0;
    for (int i = 0; i < sum.size(); i++) {
      long l = lower + sum[i];
      long h = upper + sum[i];
      int lower_index = searchLowerIndex(sum, i + 1, sum.size() - 1, l);
      cout << sum[i] << " " << l << " " << h << endl;
      // 下界可能找不到，如果有下边界则一定有上边界
      if (lower_index < sum.size()) {
        int high_index =
            searchLowerIndex(sum, lower_index, sum.size() - 1, h + 1) - 1;
        cout << "[ " << lower_index << " " << high_index << " ]" << endl;
        count += high_index - lower_index + 1;
      }
    }
    return count;
  }
  int searchLowerIndex(vector<long> &nums, int start, int end, long target) {
    int left = start, right = end;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
};
// @lc code=end
