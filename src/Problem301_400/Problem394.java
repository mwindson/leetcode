package Problem301_400;

import java.util.Stack;

/**
 * Created by mwindson on 2017/4/1.
 * https://leetcode.com/problems/decode-string/#/description
 */
public class Problem394 {
    public static void main(String[] args) {
        String s = "3[a]2[de]3[gh]";
        System.out.println(decodeString(s));
    }

    // one stack
//    public static String decodeString(String s) {
//        Stack<Character> stack = new Stack<>();
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != ']') {
//                stack.push(s.charAt(i));
//            } else {
//                StringBuilder sb = new StringBuilder();
//                StringBuilder num = new StringBuilder();
//                int count = 0;
//                while (stack.peek() != '[') {
//                    sb.append(stack.pop());
//                }
//                sb.reverse();
//                stack.pop();
//                while (!stack.isEmpty() && (stack.peek() >= '0' && stack.peek() <= '9')) {
//                    num.append(stack.pop());
//                }
//                count = Integer.valueOf(num.reverse().toString());
//                String tmp = "";
//                for (int j = 0; j < count; j++) {
//                    tmp += sb;
//                }
//                char[] chars = tmp.toCharArray();
//                for (char c : chars)
//                    stack.push(c);
//            }
//        }
//        while (!stack.isEmpty()) {
//            res.append(stack.pop());
//        }
//        return res.reverse().toString();
//    }

    //two stack
    public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
