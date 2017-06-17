package Problem001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/16.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/#/description
 */
public class Problem030 {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return result;
        int len = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);

        // all words has the same length
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) { // check if match
                String str = s.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        result.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return result;
    }
}
