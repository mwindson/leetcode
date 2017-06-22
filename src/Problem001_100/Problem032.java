package Problem001_100;

import java.util.Stack;

/**
 * Created by mwindson on 2017/6/22.
 * https://leetcode.com/problems/longest-valid-parentheses/#/description
 */
public class Problem032 {
    // todo TLE on the last case
    public static void main(String[] args) {
        String s = ")()())(())()";
        System.out.println(longestValidParentheses(s));
    }

    //    If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.
    //    if s[i] is ')'
    //          If s[i-1] is '(' => longest[i] = longest[i-2] + 2
    //          if s[i-1] is ')' and s[i-longest[i-1]-1] == '(' => longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
    public static int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int curMax = 0;
        int[] longest = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // ()
                if (s.charAt(i - 1) == '(') {
                    longest[i] = i >= 2 ? (longest[i - 2] + 2) : 2;
                    curMax = Math.max(longest[i], curMax);
                } else {
                    // if s[i-1] == ')', combine the previous length.
                    if (i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
                        longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                        curMax = Math.max(longest[i], curMax);
                    }
                }
            }
            //else if s[i] == '(', skip it, because longest[i] must be 0
        }
        return curMax;
    }
}
