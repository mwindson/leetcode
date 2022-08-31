/*
 * @lc app=leetcode id=307 lang=cpp
 *
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (38.77%)
 * Likes:    3993
 * Dislikes: 218
 * Total Accepted:    230.2K
 * Total Submissions: 567.3K
 * Testcase Example:
 * '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, handle multiple queries of the following
 * types:
 *
 *
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right
 * inclusive where left <= right.
 *
 *
 * Implement the NumArray class:
 *
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be
 * val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums
 * between indices left and right inclusive (i.e. nums[left] + nums[left + 1] +
 * ... + nums[right]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 *
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * At most 3 * 10^4 calls will be made to update and sumRange.
 *
 *
 */

// @lc code=start
class NumArray {
public:
  NumArray(vector<int> &nums) {
    nums_ = nums;
    range_sum_.resize(nums.size() * 4, 0);
    lazy_.resize(nums.size() * 4, 0);
    build(0, nums_.size() - 1, 0);
  }

  void update(int index, int val) {
    int delta = val - nums_[index];
    nums_[index] = val;
    updateRange(index, index, 0, nums_.size() - 1, delta, 0);
  }

  int sumRange(int left, int right) {
    return getSum(left, right, 0, nums_.size() - 1, 0);
  }

private:
  void build(int start, int end, int node) {
    if (start == end) {
      range_sum_[node] = nums_[start];
      return;
    }
    int mid = (end - start) / 2 + start;
    build(start, mid, node * 2 + 1);
    build(mid + 1, end, node * 2 + 2);
    range_sum_[node] = range_sum_[node * 2 + 1] + range_sum_[node * 2 + 2];
  }
  long getSum(int l, int r, int start, int end, int node) {
    if (l <= start && r >= end) {
      return range_sum_[node];
    }
    int mid = (end - start) / 2 + start;
    long sum = 0;
    // 如果延迟修改非空，则需要更新子节点值和延迟修改值
    int left_node = node * 2 + 1;
    int right_node = node * 2 + 2;
    // 如果延迟修改非空,需要传递给左右节点值和延迟修改值
    if (lazy_[node]) {
      range_sum_[left_node] += (mid - start + 1) * lazy_[node];
      range_sum_[right_node] += (end - mid) * lazy_[node];
      lazy_[left_node] += lazy_[node];
      lazy_[right_node] += lazy_[node];
      lazy_[node] = 0; // clear
    }
    if (l <= mid) {
      sum += getSum(l, r, start, mid, node * 2 + 1);
    }
    if (r > mid) {
      sum += getSum(l, r, mid + 1, end, node * 2 + 2);
    }
    return sum;
  }
  // [l,r] 修改区间 [start,end]当前节点所在区间，delta变化值，node当前节点的编号
  void updateRange(int l, int r, int start, int end, int delta, int node) {
    if (l <= start && r >= end) {
      range_sum_[node] += (end - start + 1) * delta;
      lazy_[node] += delta;
      return;
    }
    int mid = (end - start) / 2 + start;
    int left_node = node * 2 + 1;
    int right_node = node * 2 + 2;
    // 如果延迟修改非空,需要传递给左右节点值和延迟修改值
    if (lazy_[node]) {
      range_sum_[left_node] += (mid - start + 1) * lazy_[node];
      range_sum_[right_node] += (end - mid) * lazy_[node];
      lazy_[left_node] += lazy_[node];
      lazy_[right_node] += lazy_[node];
      lazy_[node] = 0; // clear
    }
    if (l <= mid) {
      updateRange(l, r, start, mid, delta, left_node);
    }
    if (r > mid) {
      updateRange(l, r, mid + 1, end, delta, right_node);
    }
    range_sum_[node] = range_sum_[node * 2 + 1] + range_sum_[node * 2 + 2];
  }

private:
  vector<long> range_sum_;
  vector<long> lazy_; // 每个节点延迟修改的值
  vector<int> nums_;
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */
// @lc code=end
