package Problem401_500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mwindson on 2017/5/25.
 * https://leetcode.com/problems/next-greater-element-i/#/solutions
 */
public class Problem496 {
    public static void main(String[] args) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
