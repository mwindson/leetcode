package Problem501_600;

import java.util.*;

/**
 * Created by mwindson on 2017/5/24.
 * https://leetcode.com/problems/kill-process/#/description
 */
public class Problem582 {
    public static void main(String[] args) {
        int[] pid = {1, 3, 10, 5};
        int[] ppid = {3, 0, 5, 3};
        int kill = 5;
        List<Integer> pidList = new ArrayList<>();
        List<Integer> ppidList = new ArrayList<>();
        for (int i = 0; i < pid.length; i++) {
            pidList.add(pid[i]);
            ppidList.add(ppid[i]);
        }
        System.out.println(killProcess(pidList, ppidList, kill));
    }

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> processKill = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            Set<Integer> children = map.getOrDefault(ppid.get(i), new HashSet<>());
            children.add(pid.get(i));
            map.put(ppid.get(i), children);
        }
        queue.add(kill);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            if (map.containsKey(parent)) {
                for (int child : map.get(parent)) {
                    queue.add(child);
                }
            }
            processKill.add(parent);
        }
        return processKill;
    }
}
