package Problem701_800;

import java.util.*;

/**
 * Created by mwindson on 2018/1/10.
 * https://leetcode.com/problems/open-the-lock/description/
 */
public class Problem752 {
    public static void main(String[] args) {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        dead.addAll(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        for (int d = 1; !q.isEmpty(); d++) {
            for (int n = q.size(); n > 0; n--) {
                String cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    for (int dif = 1; dif <= 9; dif += 8) {
                        char[] charArray = cur.toCharArray();
                        charArray[i] = (char) ((charArray[i] - '0' + dif) % 10 + '0');
                        String s = new String(charArray);
                        if (target.equals(s)) return d;
                        if (!dead.contains(s) && !visited.contains(s)) q.add(s);
                        visited.add(s);
                    }
                }
            }
        }
        return -1;
    }
}