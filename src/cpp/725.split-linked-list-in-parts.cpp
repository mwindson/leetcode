/*
 * @lc app=leetcode id=725 lang=cpp
 *
 * [725] Split Linked List in Parts
 *
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 *
 * algorithms
 * Medium (56.88%)
 * Likes:    1885
 * Dislikes: 198
 * Total Accepted:    98.9K
 * Total Submissions: 173.6K
 * Testcase Example:  '[1,2,3]\n5'
 *
 * Given the head of a singly linked list and an integer k, split the linked
 * list into k consecutive linked list parts.
 *
 * The length of each part should be as equal as possible: no two parts should
 * have a size differing by more than one. This may lead to some parts being
 * null.
 *
 * The parts should be in the order of occurrence in the input list, and parts
 * occurring earlier should always have a size greater than or equal to parts
 * occurring later.
 *
 * Return an array of the k parts.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a
 * ListNode is [].
 *
 *
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most
 * 1, and earlier parts are a larger size than the later parts.
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the list is in the range [0, 1000].
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
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
  vector<ListNode *> splitListToParts(ListNode *head, int k) {
    vector<ListNode *> res;
    int cnt = 0;
    auto node = head;
    while (node != nullptr) {
      cnt++;
      node = node->next;
    }
    int basic = cnt / k;
    int moreCnt = cnt % k;
    node = head;
    for (int i = 0; i < k; i++) {
      auto start = node;
      for (int j = 0; j < (i < moreCnt ? basic : (basic - 1)); j++) {
        node = node->next;
      }
      auto end = node;
      if (node != nullptr) {
        node = node->next;
        end->next = nullptr;
      }
      res.emplace_back(start);
    }
    return res;
  }
};
// @lc code=end
