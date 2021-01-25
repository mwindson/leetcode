import java.util.*;
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] in = new int[numCourses];
        int[] out = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            in[b]++;
            out[a]++;
            var set = graph.getOrDefault(a, new HashSet<>());
            set.add(b);
            graph.put(a, set);
        }
        return helper(in, out, graph);
    }

    boolean helper(int[] in, int[] out, Map<Integer, Set<Integer>> graph) {
        int start = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                in[i]--;
                break;
            }
        }
        if (start >= 0) {
            for (int node : graph.get(start)) {
                in[node]--;
            }
        } else {
            return graph.size() == 0;
        }
        return helper(in, out, graph);
    }
}
// @lc code=end
