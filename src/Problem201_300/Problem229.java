package Problem201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/6/27.
 * https://leetcode.com/problems/majority-element-ii/#/solutions
 */
public class Problem229 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;
    }
}
