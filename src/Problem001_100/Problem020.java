package Problem001_100;

import java.util.Calendar;
import java.util.Stack;

/**
 * Created by mwindson on 2017/2/1.
 * Question; https://leetcode.com/problems/valid-parentheses/
 */
public class Problem020 {
    public static void main(String[] args) {
        String s = ")]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
//                stack.push(s.charAt(i));
//            } else {
//                if (stack.empty()) return false;
//                if (s.charAt(i) == ')' && stack.peek() == '(') {
//                    stack.pop();
//                } else if (s.charAt(i) == '}' && stack.peek() == '{') {
//                    stack.pop();
//                } else if (s.charAt(i) == ']' && stack.peek() == '[') {
//                    stack.pop();
//                } else {
//                    break;
//                }
//            }
//        }
//        return stack.empty();

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
