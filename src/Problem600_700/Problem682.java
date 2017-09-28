package Problem600_700;

import java.util.Stack;

/**
 * Created by mwindson on 2017/9/25.
 * https://leetcode.com/problems/baseball-game/description/
 */
public class Problem682 {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int last = stack.pop();
                    int point = last + stack.peek();
                    stack.push(last);
                    stack.push(point);
                    break;
                case "D":
                    if (!stack.isEmpty()) stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(op));
                    break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
