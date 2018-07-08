package nowcoder;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class P20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty() || node <= min.peek()) {
            min.push(node);
        }

    }

    public void pop() {
        int num = stack.pop();
        if (!min.isEmpty() && num == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
