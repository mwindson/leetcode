package Problem600_700;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/8/2.
 * https://leetcode.com/problems/dota2-senate/description/
 */
public class Problem649 {
    public static void main(String[] args) {
        String senate = "DRRDRDRDRDDRDRDR";
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        int n = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D')
                q1.add(i);
            else
                q2.add(i);
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int index1 = q1.poll(), index2 = q2.poll();
            if (index1 < index2) {
                q1.add(index1 + n);
            } else {
                q2.add(index2 + n);
            }
        }
        return (q1.size() < q2.size()) ? "Radiant" : "Dire";
    }
}
