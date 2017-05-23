package Problem501_600;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/5/23.
 * https://leetcode.com/problems/friend-circles/#/description
 */
public class Problem547 {
    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };
        System.out.println(findCircleNum(M));
    }

    public static int findCircleNum(int[][] M) {
        if (M.length == 0) return 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
                bfs(M, queue, visited);
                count++;
            }
        }
        return count;
    }

    public static void bfs(int[][] M, Queue<Integer> q, boolean[] visited) {
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < M.length; i++) {
                if (!visited[i] && M[current][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
