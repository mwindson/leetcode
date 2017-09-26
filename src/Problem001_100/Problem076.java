package Problem001_100;

import sun.misc.resources.Messages_pt_BR;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/8/22.
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class Problem076 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String result = "";
        if (s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int letterCount = 0;
        int minLength = Integer.MAX_VALUE;
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.getOrDefault(c, 0) <= map.getOrDefault(c, 0)) {
                letterCount++;
            }
            if (letterCount >= t.length()) {
                while (map.getOrDefault(s.charAt(slow), 0) == 0 || window.get(s.charAt(slow)) > map.get(s.charAt(slow))) {
                    window.put(s.charAt(slow), window.getOrDefault(s.charAt(slow), 0) - 1);
                    slow++;
                }
                if (fast - slow + 1 < minLength) {
                    minLength = fast - slow + 1;
                    result = s.substring(slow, fast + 1);
                }
            }
        }
        return result;
    }
}
