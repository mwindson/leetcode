package Problem001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/16.
 * https://leetcode.com/problems/permutations/#/description
 */
public class Problem046 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutions = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backTracking(permutions, tmpList, nums);
        return permutions;
    }

    private static void backTracking(List<List<Integer>> permutions, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            permutions.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i])) continue;
                tmpList.add(nums[i]);
                backTracking(permutions, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
