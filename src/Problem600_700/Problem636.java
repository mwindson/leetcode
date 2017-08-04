package Problem600_700;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by mwindson on 2017/8/2.
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 */
public class Problem636 {
    public static void main(String[] args) {
        int n = 3;
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:start:3","1:end:4","1:end:5","0:end:6");
        System.out.println(Arrays.toString(exclusiveTime(n, logs)));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime;
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}
