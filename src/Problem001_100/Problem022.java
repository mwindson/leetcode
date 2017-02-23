package Problem001_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mwindson on 2017/2/14.
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Problem022 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        Stack<String> stack = new Stack<String>();
        String s = "";
        int pLeft = n;
        int pRight = n;
        stackGenPar(s, stack, parenthesis, pLeft, pRight);
        return parenthesis;
    }

    private static void stackGenPar(String s, Stack<String> stack, List<String> p, int pLeft, int pRight) {
        if (pLeft == 0 && pRight == 0) {
            if (!s.equals("")) {
                p.add(s);
            }
        } else {
            if (pLeft > 0) {
                stack.push("(");
                stackGenPar(s + '(', stack, p, pLeft - 1, pRight);
                stack.pop();
            }
            if (!stack.empty() && pRight > 0) {
                stack.pop();
                stackGenPar(s + ")", stack, p, pLeft, pRight - 1);
                stack.push("(");
            }
        }
    }
}
