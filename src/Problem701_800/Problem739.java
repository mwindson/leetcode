package Problem701_800;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mwindson on 2017/12/6.
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class Problem739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] waitDays = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int top = stack.peek();
                if (temperatures[top] >= temperatures[i]) {
                    stack.push(i);
                } else {
                    while (temperatures[top] < temperatures[i]) {
                        waitDays[top] = i - top;
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        } else {
                            top = stack.peek();
                        }
                    }
                    stack.push(i);
                }
            }
        }
        return waitDays;
    }
}
