import Util.Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/3/24.
 */
// 华为java试题，有向图的求最短路径
public class ProblemHW2 {
    static int minDis = -1;
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        minDistance(2, 4);
        System.out.println(minDis);
        System.out.println(res);
    }

    public static void minDistance(int x, int y) {
        int[][] time = {
                {0, 2, 10, 5, 3, -1},
                {-1, 0, 12, -1, -1, 10},
                {-1, -1, 0, -1, 7, -1},
                {2, -1, -1, 0, 2, -1},
                {4, -1, -1, 1, 0, -1},
                {3, -1, 1, -1, 2, 0}
        };
        List<Integer> plan = new ArrayList<>();
        boolean[] visited = new boolean[6];
        int cur = 4, des = x - 1;
        // 大雾城市
        if (y != 0) {
            for (int j = 0; j < 6; j++) {
                time[y - 1][j] = -1;
            }
            for (int i = 0; i < 6; i++) {
                time[i][y - 1] = -1;
            }
        }
        plan.add(5);
        dfs(time, visited, cur, des, plan, 0);
    }

    private static void dfs(int[][] time, boolean[] visited, int cur, int des, List<Integer> list, int dis) {
        if (cur == des) {
            if (minDis == -1 || (minDis != -1 && minDis > dis)) {
                minDis = dis;
                res = new ArrayList<>(list);
            }
        } else {
            for (int i = 0; i < 6; i++) {
                if (time[cur][i] != -1 && !visited[i]) {
                    list.add(i + 1);
                    visited[i] = true;
                    dfs(time, visited, i, des, list, dis + time[cur][i]);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
