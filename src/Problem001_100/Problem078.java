package Problem001_100;

import Util.Interval;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/2/25.
 * https://leetcode.com/problems/subsets/?tab=Description
 */
public class Problem078 {
    public static void main(String[] args) {
        int[] nums = {0,3,9};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums, i, -1, nums.length - 1, subsets, subset);
        }
        return subsets;
    }

    public static void backTrack(int[] nums, int length, int first, int end, List<List<Integer>> subsets, List<Integer> subset) {
        if (length == 0) {
            subsets.add(new ArrayList<>(subset));
        } else {
            for (int i = first + 1; i <= end; i++) {
                subset.add(nums[i]);
                backTrack(nums, length - 1, i, end, subsets, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
