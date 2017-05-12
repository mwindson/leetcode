package Problem301_400;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by mwindson on 2017/5/12.
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/#/description
 */
public class Problem331 {
    public static void main(String[] args) {
        String preorder = "1,#,#,#,#";
        System.out.println(isValidSerialization(preorder));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if (stack.isEmpty()) {
                stack.push(strings[i]);
            } else {
                if (Objects.equals(strings[i], "#")) {
                    while (Objects.equals(stack.peek(), "#")) {
                        stack.pop();
                        if (stack.isEmpty()) return false;
                        stack.pop();
                        if (stack.isEmpty()) break;
                    }
                    stack.push(strings[i]);
                } else {
                    stack.push(strings[i]);
                }
            }
        }
        if (Objects.equals(stack.peek(), "#")) stack.pop();
        return stack.isEmpty();
    }
}
