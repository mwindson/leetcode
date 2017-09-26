package Problem301_400;

import java.util.*;

/**
 * Created by mwindson on 2017/9/1.
 * https://leetcode.com/problems/minimum-height-trees/description/
 */
public class Problem310 {
    // n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(findMinHeightTrees(n, edges));
    }

    // the BFS topological sort: remove leaves and add new leaves
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
