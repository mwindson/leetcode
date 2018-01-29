package Problem701_800;

import java.util.HashMap;
import java.util.Map;

/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class Problem771 {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : J.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                count++;
            }
        }
        return count;
    }
}
