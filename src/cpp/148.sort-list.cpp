/*
 * @lc app=leetcode id=148 lang=cpp
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (52.41%)
 * Likes:    7477
 * Dislikes: 240
 * Total Accepted:    512.4K
 * Total Submissions: 971.2K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
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
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 *
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory
 * (i.e. constant space)?
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
  ListNode *sortList(ListNode *head) {
    if (head == nullptr || head->next == nullptr) {
      return head;
    }
    auto slow = head;
    auto fast = head->next; // must be differnt start node;
    while (fast != nullptr && fast->next != nullptr) {
      fast = fast->next->next;
      slow = slow->next;
    }
    auto curr = slow->next;
    slow->next = nullptr;
    return merge(sortList(head), sortList(curr));
  }
  ListNode *merge(ListNode *a, ListNode *b) {
    ListNode fake;
    ListNode *curr = &fake;
    while (a != nullptr && b != nullptr) {
      if (a->val < b->val) {
        curr->next = a;
        a = a->next;
      } else {
        curr->next = b;
        b = b->next;
      }
      curr = curr->next;
    }
    if (a != nullptr) {
      curr->next = a;
    } else {
      curr->next = b;
    }
    return fake.next;
  }
};
// @lc code=end
