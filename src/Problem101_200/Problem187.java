package Problem101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/5/31.
 * https://leetcode.com/problems/repeated-dna-sequences/#/description
 */
public class Problem187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedDNA = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        for (String l : map.keySet()) {
            if (map.get(l) >= 2) {
                repeatedDNA.add(l);
            }
        }
        return repeatedDNA;
    }
}
