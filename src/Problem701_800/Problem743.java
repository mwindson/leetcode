package Problem701_800;

import java.util.*;

/**
 * Created by mwindson on 2017/12/12.
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class Problem743 {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4;
        int K = 2;
        System.out.println(networkDelayTime(times, N, K));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] nums = times[i];
            int u = nums[0];
            List<Integer> list = map.getOrDefault(u, new ArrayList<>());
            list.add(i);
            map.put(u, list);
        }
        if (map.get(K) == null) return -1;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(K);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int t = dist[u];
            List<Integer> list = map.get(u);
            if (list == null) continue;
            for (int n : list) {
                int v = times[n][1];
                int time = times[n][2];
                if (dist[v] > t + time) {
                    dist[v] = t + time;
                    queue.add(v);
                }
            }
        }
        int res = -1;

        for (int i = 1; i <= N; i++) {
            int d = dist[i];
            if (d == Integer.MAX_VALUE) {// if d is max, it means node i can not be reached from K, so return -1
                return -1;
            }
            res = d > res ? d : res;
        }

        return res;
    }
}
