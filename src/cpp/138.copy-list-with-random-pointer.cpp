/*
 * @lc app=leetcode id=138 lang=cpp
 *
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (48.57%)
 * Likes:    9347
 * Dislikes: 1031
 * Total Accepted:    835.6K
 * Total Submissions: 1.7M
 * Testcase Example:  '[[7,null],[13,0],[11,4],[10,2],[1,0]]'
 *
 * A linked list of length n is given such that each node contains an
 * additional random pointer, which could point to any node in the list, or
 * null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random
 * pointer points to, or null if it does not point to any node.
 *
 *
 * Your code will only be given the head of the original linked list.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 *
 * Example 3:
 *
 *
 *
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= n <= 1000
 * -10^4 <= Node.val <= 10^4
 * Node.random is null or is pointing to some node in the linked list.
 *
 *
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
  Node *copyRandomList(Node *head) {
    if (head == nullptr) {
      return head;
    }
    auto l1 = head;
    Node *l2 = nullptr;
    // 节点和其随机节点中插入一个节点
    while (l1 != nullptr) {
      l2 = new Node(l1->val);
      l2->next = l1->random;
      l1->random = l2;
      l1 = l1->next;
    }
    // 插入的新节点 更新随机节点
    l1 = head;
    while (l1 != nullptr) {
      l2 = l1->random;
      l2->random = l2->next != nullptr ? l2->next->random : nullptr;
      l1 = l1->next;
    }
    // 拆分出新的节点为新的链表
    l1 = head;
    auto l2_head = l1->random;
    while (l1 != nullptr) {
      l2 = l1->random;
      l1->random = l2->next;
      l2->next = l1->next != nullptr ? l1->next->random : nullptr;
      l1 = l1->next;
    }
    return l2_head;
  }
};
// @lc code=end
