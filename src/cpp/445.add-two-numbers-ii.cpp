/*
 * @lc app=leetcode id=445 lang=cpp
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (58.78%)
 * Likes:    3675
 * Dislikes: 228
 * Total Accepted:    322K
 * Total Submissions: 546.3K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 *
 *
 * Example 2:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 *
 *
 * Example 3:
 *
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 *
 *
 *
 * Follow up: Could you solve it without reversing the input lists?
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
  ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    if (l1 == nullptr) {
      return l2;
    }
    if (l2 == nullptr) {
      return l1;
    }
    int cnt1 = countNode(l1);
    int cnt2 = countNode(l2);
    if (cnt1 < cnt2) {
      return addTwoNumbers(l2, l1);
    }
    int diff = cnt1 - cnt2;

    while (diff > 0) {
      ListNode *node = new ListNode(0);
      node->next = l2;
      l2 = node;
      diff--;
    }
    int carryBit = 0;
    auto res = addNode(l1, l2, carryBit);
    if (carryBit == 1) {
      ListNode *node = new ListNode(1);
      node->next = res;
      res = node;
    }
    return res;
  }
  ListNode *addNode(ListNode *l1, ListNode *l2, int &carryBit) {
    if (l1 == nullptr || l2 == nullptr) {
      return nullptr;
    }
    int a = l1 == nullptr ? 0 : l1->val;
    int b = l2 == nullptr ? 0 : l2->val;
    int nextCarryBit = 0;
    auto *next = addNode(l1->next, l2->next, nextCarryBit);
    int sum = a + b + nextCarryBit;
    if (sum >= 10) {
      carryBit = 1;
      sum -= 10;
    }
    ListNode *head = new ListNode(sum);
    head->next = next;
    return head;
  }

  int countNode(ListNode *l) {
    int cnt = 0;
    while (l != nullptr) {
      l = l->next;
      cnt++;
    }
    return cnt;
  }
};
// @lc code=end
