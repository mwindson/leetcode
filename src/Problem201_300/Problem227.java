package Problem201_300;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mwindson on 2017/4/9.
 * https://leetcode.com/problems/basic-calculator-ii/#/description
 */
public class Problem227 {
    public static void main(String[] args) {
        String[] inputs = {" 1-1+1 ", " 23/2 ", "33- 15  /2 ", "42   -5", "-36"};
        for (String input : inputs) {
            System.out.println(calculate(input));
        }
    }

    public static int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }
}
