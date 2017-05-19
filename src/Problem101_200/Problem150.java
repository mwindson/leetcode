package Problem101_200;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by mwindson on 2017/5/19.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
 */
public class Problem150 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (Objects.equals(tokens[i], "+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if (Objects.equals(tokens[i], "-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (Objects.equals(tokens[i], "*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (Objects.equals(tokens[i], "/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
