/*
 * @lc app=leetcode id=61 lang=cpp
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (35.05%)
 * Likes:    5612
 * Dislikes: 1286
 * Total Accepted:    586.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, rotate the list to the right by k
 * places.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
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
  ListNode *rotateRight(ListNode *head, int k) {
    if (head == nullptr) {
      return head;
    }
    int cnt = 0;
    auto node = head;
    while (node != nullptr) {
      node = node->next;
      cnt++;
    }
    k = k % cnt;
    if (k == 0) {
      return head;
    }
    auto first = head;
    auto second = head;
    for (int i = 0; i < k; i++) {
      first = first->next;
    }
    while (first->next != nullptr) {
      second = second->next;
      first = first->next;
    }
    auto res = second->next;
    first->next = head;
    second->next = nullptr;

    return res;
  }
};
// @lc code=end
