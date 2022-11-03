/*
 * @lc app=leetcode id=74 lang=cpp
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (44.88%)
 * Likes:    8175
 * Dislikes: 285
 * Total Accepted:    848.1K
 * Total Submissions: 1.9M
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 *
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool searchMatrix(vector<vector<int>> &matrix, int target) {
    if (matrix.size() == 0 || matrix[0].size() == 0) {
      return false;
    }
    // 二分法
    // int m = matrix.size();
    // int n = matrix[0].size();
    // int l = 0;
    // int r = m * n - 1;
    // while (l <= r) {
    //   int mid = (r - l) / 2 + l;
    //   int val = matrix[mid / n][mid % n];
    //   if (val > target) {
    //     r = mid - 1;
    //   } else if (val == target) {
    //     return true;
    //   } else {
    //     l = mid + 1;
    //   }
    // }
    // return false;
    // 右上角开始搜索
    int i = 0;
    int j = matrix[i].size() - 1;
    while (i < matrix.size() && j >= 0) {
      int val = matrix[i][j];
      if (val > target) {
        j--;
      } else if (val == target) {
        return true;
      } else {
        i++;
      }
    }
    return false;
  }
};
// @lc code=end
