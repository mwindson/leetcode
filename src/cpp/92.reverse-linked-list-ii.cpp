/*
 * @lc app=leetcode id=92 lang=cpp
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (43.56%)
 * Likes:    6297
 * Dislikes: 298
 * Total Accepted:    490.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Given the head of a singly linked list and two integers left and right where
 * left <= right, reverse the nodes of the list from position left to position
 * right, and return the reversed list.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 *
 * Follow up: Could you do it in one pass?
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
  ListNode *reverseBetween(ListNode *head, int left, int right) {
    if (head == nullptr) {
      return head;
    }
    ListNode *fake = new ListNode();
    fake->next = head;
    auto start = fake;
    int i = 1;
    for (; i < left; i++) {
      start = start->next;
    }
    auto curr = start->next;
    auto end = start->next;
    while (curr != nullptr && i <= right) {
      auto tmp = curr->next;
      curr->next = start->next;
      start->next = curr;
      end->next = tmp;
      curr = tmp;
      i++;
    }
    return fake->next;
  }
};
// @lc code=end
