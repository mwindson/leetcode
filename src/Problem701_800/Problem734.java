package Problem701_800;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mwindson on 2017/12/1.
 * https://leetcode.com/problems/sentence-similarity/description/
 */
public class Problem734 {
    public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs) {
            if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }


        for (int i = 0; i < words1.length; i++)
            if (!words1[i].equals(words2[i]) && !map.getOrDefault(words1[i], new HashSet<>()).contains(words2[i]) && !map.getOrDefault(words2[i], new HashSet<>()).contains(words1[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String[] words1 = {"great"};
        String[] words2 = {"doubleplus", "good"};
        String[][] pairs = {{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"}};
        System.out.println(areSentencesSimilar(words1, words2, pairs));
    }
}
