package Problem001_100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/2/28.
 * https://leetcode.com/problems/subsets-ii/?tab=Description
 */
public class Problem090 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backTrack(subsets, subset, 0, nums);
        return subsets;
    }

    private static void backTrack(List<List<Integer>> subsets, List<Integer> subset, int start, int[] nums) {
        if (start <= nums.length) {
            subsets.add(new ArrayList<>(subset));
        }
        int i = start;
        while (i < nums.length) {
            subset.add(nums[i]);
            backTrack(subsets, new ArrayList<>(subset), i + 1, nums);
            subset.remove(subset.size() - 1);
            i++;
            //重复情况剪枝
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return;
    }
}
