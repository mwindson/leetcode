package Problem201_300;

import java.util.HashMap;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/isomorphic-strings/#/description
 */
public class Problem205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else
                    return false;
            }
        }
        return true;
    }
}
