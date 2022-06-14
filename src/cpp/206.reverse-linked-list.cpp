/*
 * @lc app=leetcode id=206 lang=cpp
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (70.61%)
 * Likes:    12367
 * Dislikes: 214
 * Total Accepted:    2.2M
 * Total Submissions: 3.1M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 *
 * Example 3:
 *
 *
 * Input: head = []
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
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
  ListNode *reverseList(ListNode *head) {
      return recursiveSolve(head);
  }
  ListNode *iterator(ListNode *head) {
    if (head == nullptr) {
      return head;
    }
    ListNode *fake = new ListNode();
    fake->next = head;
    auto *node = head->next;
    head->next = nullptr;
    while (node != nullptr) {
      auto *next = node->next;
      node->next = fake->next;
      fake->next = node;
      node = next;
    }
    return fake->next;
  }
  ListNode *recursiveSolve(ListNode *head) {
    if (head == nullptr) {
      return head;
    }
    
  }
};
// @lc code=end
