package Problem001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/3/16.
 * https://leetcode.com/problems/permutations-ii/#/description
 */
public class Problem047 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        boolean[] used = new boolean[nums.length + 1];
        Arrays.sort(nums);
        backTracking(permutations, tmpList, nums, used);
        return permutations;
    }

    // used数组标示当前位置nums数组的数字是否被使用
    private static void backTracking(List<List<Integer>> permutations, List<Integer> tmpList, int[] nums, boolean[] used) {
        if (tmpList.size() == nums.length) {
            permutations.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                // 排除相同情况的数字顺序
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
                tmpList.add(nums[i]);
                used[i] = true;
                backTracking(permutations, tmpList, nums, used);
                used[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
