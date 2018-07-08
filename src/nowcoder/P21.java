package nowcoder;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class P21 {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(new P21().IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushA.length) {
            if (pushA[i] == popA[j]) {
                j++;
            } else {
                stack.push(pushA[i]);
            }
            i++;
        }
        while (j < popA.length) {
            if (stack.isEmpty() || popA[j] != stack.peek()) return false;
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }
}
