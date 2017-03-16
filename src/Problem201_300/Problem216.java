package Problem201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/16.
 * https://leetcode.com/problems/combination-sum-iii/#/description
 */
public class Problem216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backTracking(combinations, tmpList, k, n, 0);
        return combinations;
    }

    private static void backTracking(List<List<Integer>> combinations, List<Integer> tmpList, int k, int n, int start) {
        if (tmpList.size() == k && n == 0) {
            combinations.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start + 1; i <= 9; i++) {
                if (tmpList.contains(i) || i > n) continue;
                tmpList.add(i);
                backTracking(combinations, tmpList, k, n - i, i);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
