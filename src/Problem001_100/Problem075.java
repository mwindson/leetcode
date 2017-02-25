package Problem001_100;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/2/25.
 * https://leetcode.com/problems/sort-colors/?tab=Description
 */
public class Problem075 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 1, 0, 0};
        sortColors(nums);
        System.out.println(nums);
    }

    public static void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
