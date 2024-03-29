/*
 * @lc app=leetcode id=23 lang=cpp
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.30%)
 * Likes:    12475
 * Dislikes: 482
 * Total Accepted:    1.3M
 * Total Submissions: 2.7M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 * Example 1:
 *
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 *
 * Example 2:
 *
 *
 * Input: lists = []
 * Output: []
 *
 *
 * Example 3:
 *
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 *
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
  struct cmp {
    bool operator()(ListNode *a, ListNode *b) { return a->val >= b->val; }
  };
  ListNode *mergeKLists(vector<ListNode *> &lists) {
    ListNode *fake = new ListNode();
    std::priority_queue<ListNode *, vector<ListNode *>, cmp> q;
    for (int i = 0; i < lists.size(); i++) {
      if (lists[i] != nullptr) {
        q.push(lists[i]);
      }
    }
    if (q.empty()) {
      return nullptr;
    }
    ListNode *node = fake;
    while (!q.empty()) {
      auto top = q.top();
      node->next = top;
      q.pop();
      if (top->next) {
        q.push(top->next);
      }
      node = node->next;
    }
    return fake->next;
  }
};
// @lc code=end
