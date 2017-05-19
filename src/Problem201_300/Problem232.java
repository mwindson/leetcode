package Problem201_300;

import java.util.Stack;

/**
 * Created by mwindson on 2017/5/19.
 * https://leetcode.com/problems/implement-queue-using-stacks/#/description
 */
public class Problem232 {
    public static class MyQueue {
        // 用两个stack组成queue
        Stack<Integer> stackInput;
        Stack<Integer> stackOutput;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackInput = new Stack<>();
            stackOutput = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!stackOutput.isEmpty())
                stackInput.push(stackOutput.pop());
            stackInput.push(x);
            while (!stackInput.isEmpty())
                stackOutput.push(stackInput.pop());
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stackOutput.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stackOutput.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackOutput.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}
