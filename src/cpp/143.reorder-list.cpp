/*
 * @lc app=leetcode id=143 lang=cpp
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (48.47%)
 * Likes:    6163
 * Dislikes: 220
 * Total Accepted:    500.9K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4]'
 *
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 *
 *
 * L0 → L1 → … → Ln - 1 → Ln
 *
 *
 * Reorder the list to be on the following form:
 *
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may
 * be changed.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is in the range [1, 5 * 10^4].
 * 1 <= Node.val <= 1000
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
  void reorderList(ListNode *head) {
    auto quick = head;
    auto slow = head;
    while (slow != nullptr && quick != nullptr && quick->next != nullptr) {
      slow = slow->next;
      quick = quick->next->next;
    }

    auto left = head;
    auto right = slow->next;
    slow->next = nullptr;
    right = reverseList(right);
    ListNode *fake = new ListNode();
    auto node = fake;
    while (left != nullptr && right != nullptr) {
      node->next = left;
      left = left->next;
      node = node->next;

      node->next = right;
      right = right->next;
      node = node->next;
    }
    if (left != nullptr) {
      node->next = left;
    }
    head = fake->next;
  }
  ListNode *reverseList(ListNode *head) {
    if (head == nullptr) {
      return head;
    }
    ListNode *fake = new ListNode();
    fake->next = head;
    auto node = head->next;
    head->next = nullptr;
    while (node != nullptr) {
      auto tmp = node->next;
      node->next = fake->next;
      fake->next = node;
      node = tmp;
    }
    return fake->next;
  }
};
// @lc code=end
