package Problem501_600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mwindson on 2017/5/25.
 * https://leetcode.com/problems/next-greater-element-ii/#/description
 */
public class Problem503 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 2};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] findNums = nums.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int it = 0; it < 2; it++) {
            for (int j = 0; j < nums.length; j++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[j])
                    map.put(stack.pop(), nums[j]);
                if (it == 0) stack.push(j);
            }
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(i, -1);
        return findNums;
    }
}
