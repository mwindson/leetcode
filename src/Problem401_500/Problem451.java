package Problem401_500;

import java.util.*;

/**
 * Created by mwindson on 2017/5/26.
 * https://leetcode.com/problems/sort-characters-by-frequency/#/description
 */
public class Problem451 {
    public static void main(String[] args) {
        String s = "AabbCCCCddD";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charFreq.put(s.charAt(i), charFreq.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charFreq.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> m : list) {
            for (int i = 0; i < m.getValue(); i++)
                res.append(m.getKey());
        }
        return res.toString();
    }
}
