package Problem001_100;

import java.util.*;

/**
 * Created by mwindson on 2017/6/26.
 * https://leetcode.com/problems/simplify-path/#/solutions
 */
public class Problem071 {
    public static void main(String[] args) {
        String path = "/abc/...";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        return "/" + String.join("/", stack);
    }
}
