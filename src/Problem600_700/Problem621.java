package Problem600_700;

import java.util.*;

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/description/
 * greedy
 */
public class Problem621 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'A', 'A', 'A'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char t : tasks) {
            counts[t - 'A']++;
        }
        Arrays.sort(counts);
        int i = 25;
        while (i >= 0 && counts[i] == counts[25]) i--;

        // 根据频次排序后,组合相同数量的字母成片,根据interval插入;
        // 宽度为interval+1
        // maxLength=(最大频次-1)*(间距+1)+最多字母宽度
        return Math.max(tasks.length, (counts[25] - 1) * (n + 1) + 25 - i);
    }
}
