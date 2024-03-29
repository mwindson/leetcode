/*
 * @lc app=leetcode id=378 lang=cpp
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (59.83%)
 * Likes:    6086
 * Dislikes: 244
 * Total Accepted:    397.7K
 * Total Submissions: 663.2K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the k^th smallest element in the matrix.
 *
 * Note that it is the k^th smallest element in the sorted order, not the k^th
 * distinct element.
 *
 * You must find a solution with a memory complexity better than O(n^2).
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
 * the 8^th smallest number is 13
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 *
 *
 *
 * Constraints:
 *
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * All the rows and columns of matrix are guaranteed to be sorted in
 * non-decreasing order.
 * 1 <= k <= n^2
 *
 *
 *
 * Follow up:
 *
 *
 * Could you solve the problem with a constant memory (i.e., O(1) memory
 * complexity)?
 * Could you solve the problem in O(n) time complexity? The solution may be too
 * advanced for an interview but you may find reading this paper fun.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int kthSmallest(vector<vector<int>> &matrix, int k) {
    int m = matrix.size();
    int n = matrix[0].size();
    int left = matrix[0][0];
    int right = matrix[m - 1][n - 1];
    int ans = -1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (countLess(matrix, mid) >= k) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
  int countLess(vector<vector<int>> &matrix, int x) {
    int cnt = 0;
    int c = matrix[0].size() - 1;
    for (int r = 0; r < matrix.size(); r++) {
      while (c >= 0 && matrix[r][c] > x) {
        c--;
      }
      cnt += c + 1;
    }
    return cnt;
  }
};
// @lc code=end
