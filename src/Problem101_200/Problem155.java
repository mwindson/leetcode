package Problem101_200;

import java.util.Stack;

/**
 * Created by mwindson on 2017/3/14.
 * https://leetcode.com/problems/min-stack/#/description
 */
public class Problem155 {
    public class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Long> s;
        long min;

        public MinStack() {
            s = new Stack<>();
        }

        // store the gap between the min value and the current value;
        public void push(int x) {
            if (s.empty()) {
                s.push(0L);
                min = x;
            } else {
                s.push(x - min);
                if (x < min) min = x;
            }
        }

        public void pop() {
            if (s.empty()) return;
            long pop = s.pop();
            if (pop < 0) min = min - pop;
        }

        public int top() {
            long top = s.peek();
            if (top > 0) {
                return (int) (top + min);
            } else {
                return (int) (min);
            }
        }

        public int getMin() {
            return (int) min;
        }
    }
}
