/*
 * @lc app=leetcode id=4 lang=cpp
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (34.29%)
 * Likes:    18711
 * Dislikes: 2173
 * Total Accepted:    1.5M
 * Total Submissions: 4.4M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 *
 * Example 2:
 *
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 *
 * Constraints:
 *
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 *
 */

// @lc code=start
class Solution {
public:
  double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
    if (nums1.size() > nums2.size()) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int m = nums1.size();
    int n = nums2.size();
    int iMin = 0, iMax = m;
    // 切分两个数组，将两个数组的左/右半部分分别组合，如果左边最大值小于右边最大值，则
    // 中位数 = (左最大+右最小)/2，否则需要调整切分的位置。
    // 切换的位置可以采用二分法。
    while (iMin <= iMax) {
      // [0,..i-1] [i,...m]
      // [0,..j-1] [j,...n]
      int i = (iMin + iMax) / 2;   // 第一个数组按i切分
      int j = (m + n + 1) / 2 - i; // 第二个数组的左侧部分
      cout << i << " " << j << endl;
      if (j != 0 && i != m && nums2[j - 1] > nums1[i]) { // i需要增大
        iMin = i + 1;
      } else if (i != 0 && j != n && nums2[j] < nums1[i - 1]) { // i需要减小
        iMax = i - 1;
      } else { // i符合条件，计算中位数
        int maxLeft = 0, minRight = 0;
        if (i == 0) {
          maxLeft = nums2[j - 1];
        } else if (j == 0) {
          maxLeft = nums1[i - 1];
        } else {
          maxLeft = max(nums1[i - 1], nums2[j - 1]);
        }
        if ((m + n) % 2 == 1) { // 奇数个时，直接返回中间值。
          return maxLeft / 1.0;
        }
        if (i == m) {
          minRight = nums2[j];
        } else if (j == n) {
          minRight = nums1[i];
        } else {
          minRight = min(nums1[i], nums2[j]);
        }
        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }
};
// @lc code=end
