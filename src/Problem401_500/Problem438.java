package Problem401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/20.
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/#/description
 */
public class Problem438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramsIndex = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(s.substring(i, i + p.length()), p))
                anagramsIndex.add(i);
        }
        return anagramsIndex;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] character = new int[26];
        for (int i = 0; i < s.length(); i++) {
            character[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            if (--character[t.charAt(j) - 'a'] < 0) {
                return false;
            }
            ;
        }
        return true;
    }
}
