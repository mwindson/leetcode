/*
 * @lc app=leetcode id=328 lang=cpp
 *
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (59.62%)
 * Likes:    5893
 * Dislikes: 391
 * Total Accepted:    568.3K
 * Total Submissions: 948.2K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the linked list is in the range [0, 10^4].
 * -10^6 <= Node.val <= 10^6
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
  ListNode *oddEvenList(ListNode *head) {
    bool is_odd = true;
    ListNode *odd_fake = new ListNode();
    ListNode *odd_head = odd_fake;
    ListNode *odd_tail = odd_fake;
    ListNode *even_fake = new ListNode();
    ListNode *even_head = even_fake;
    while (head != nullptr) {
      auto tmp = head->next;
      if (is_odd) {
        odd_head->next = head;
        head->next = nullptr;
        odd_head = odd_head->next;
        odd_tail = odd_head;
      } else {
        even_head->next = head;
        head->next = nullptr;
        even_head = even_head->next;
      }
      is_odd = !is_odd;
      head = tmp;
    }
    odd_tail->next = even_fake->next;
    return odd_fake->next;
  }
};
// @lc code=end
