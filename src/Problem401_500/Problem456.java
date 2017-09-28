package Problem401_500;

import java.util.Stack;

/**
 * Created by mwindson on 2017/9/28.
 * https://leetcode.com/problems/132-pattern/description/
 */
public class Problem456 {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 6};
        System.out.println(find132pattern(nums));
    }

    static class Pair {
        int min, max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min) stack.push(new Pair(n, n));
            else if (n > stack.peek().min) {
                Pair last = stack.pop();
                if (n < last.max) return true;
                else {
                    last.max = n;
                    while (!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if (!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
            }
        }
        return false;
    }
}
