package Problem001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/2/17.
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class Problem040 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        combineSum2(candidates, target, -1, combination, result);
        return result;
    }

    public static void combineSum2(int[] num, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
        if (!(combination.isEmpty() && index > -1 && num[index + 1] != num[index])) {
            if (target == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(combination);
                if (!combinations.contains(tmp))
                    combinations.add(tmp);
            } else if (target > 0) {
                for (int i = index + 1; i < num.length && num[i] <= target; i++) {
                    combination.add(num[i]);
                    combineSum2(num, target - num[i], i, combination, combinations);
                }
            }
            if (!combination.isEmpty())
                combination.remove(combination.size() - 1);
        }
    }
}
