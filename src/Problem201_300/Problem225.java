package Problem201_300;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/5/19.
 * https://leetcode.com/problems/implement-stack-using-queues/#/description
 */
public class Problem225 {
    public static class MyStack {
        Queue<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q.add(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}
