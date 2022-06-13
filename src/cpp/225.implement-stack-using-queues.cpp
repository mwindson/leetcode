/*
 * @lc app=leetcode id=225 lang=cpp
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (55.58%)
 * Likes:    2944
 * Dislikes: 875
 * Total Accepted:    347.8K
 * Total Submissions: 624.5K
 * Testcase Example:
 * '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 *
 *
 * Notes:
 *
 *
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 *
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 *
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 *
 *
 *
 * Follow-up: Can you implement the stack using only one queue?
 *
 */

// @lc code=start
class MyStack {
public:
  MyStack() {}

  void push(int x) {
    q.push_back(x);
    int size = q.size();
    while (size > 1) {
      q.push_back(q.front());
      q.pop_front();
      size--;
    }
  }

  int pop() {
    int front = q.front();
    q.pop_front();
    return front;
  }

  int top() { return q.front(); }

  bool empty() { return q.empty(); }

private:
  deque<int> q;
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
// @lc code=end
