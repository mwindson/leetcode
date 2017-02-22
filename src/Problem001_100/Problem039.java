package Problem001_100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mwindson on 2017/2/16.
 * https://leetcode.com/problems/combination-sum/
 */
public class Problem039 {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        combineSum(candidates, target, 0, combination, result);
        return result;
    }

    public static void combineSum(int[] num, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(combination);
            if (!combinations.contains(tmp))
                combinations.add(tmp);
        } else if (target > 0) {
            for (int i = index; i < num.length && num[i] <= target; i++) {
                combination.add(num[i]);
                combineSum(num, target - num[i], i, combination, combinations);
            }
        }
        if (!combination.isEmpty())
            combination.remove(combination.size() - 1);
    }
}
