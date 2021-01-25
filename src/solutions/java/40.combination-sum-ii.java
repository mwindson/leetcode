package solutions.java;

import java.util.*;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(0, target, curr, ans, candidates, -1);
        return ans;
    }

    public void dfs(int sum, int target, List<Integer> curr, List<List<Integer>> ans, int[] candidates, int start) {
        for (int i = start + 1; i < candidates.length; i++) {
            if (sum + candidates[i] > target || (i >= start + 2 && candidates[i] == candidates[i - 1])) {
                continue;
            }
            sum += candidates[i];
            curr.add(candidates[i]);
            if (sum == target) {
                ans.add(new LinkedList<>(curr));
            } else if (sum < target) {
                dfs(sum, target, curr, ans, candidates, i);
            }
            sum -= candidates[i];
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end
