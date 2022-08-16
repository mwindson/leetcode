/*
 * @lc app=leetcode id=25 lang=cpp
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (51.48%)
 * Likes:    8544
 * Dislikes: 527
 * Total Accepted:    571.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
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
  ListNode *reverseKGroup(ListNode *head, int k) {
    ListNode *fake = new ListNode();
    auto tail = head;
    auto prev = fake;
    while (tail != nullptr) {
      int i = 1;
      for (; i < k && tail->next != nullptr; i++) {
        tail = tail->next;
      }
      if (i < k) {
        prev->next = head;
        break;
      }
      auto tmp = tail->next;
      tail->next = nullptr;
      auto originHead = head;
      head = reverseList(head);
      prev->next = head;
      prev = originHead;
      tail = tmp;
      head = tmp;
    }
    return fake->next;
  }
  ListNode *reverseList(ListNode *head) {
    if (head == nullptr) {
      return nullptr;
    }
    ListNode *fake = new ListNode();
    fake->next = head;
    auto curr = head->next;
    head->next = nullptr;
    while (curr != nullptr) {
      auto tmp = curr->next;
      curr->next = fake->next;
      fake->next = curr;
      curr = tmp;
    }
    return fake->next;
  }
};
// @lc code=end
