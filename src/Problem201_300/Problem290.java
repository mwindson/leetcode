package Problem201_300;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by mwindson on 2017/5/11.
 * https://leetcode.com/problems/word-pattern/#/description
 */
public class Problem290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        char[] patternChar = pattern.toCharArray();
        String[] words = str.split(" ");
        if (patternChar.length != words.length) return false;
        for (int i = 0; i < patternChar.length; i++) {
            if (map.containsKey(patternChar[i])) {
                if (!Objects.equals(map.get(patternChar[i]), words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                } else {
                    map.put(patternChar[i], words[i]);
                }
            }
        }
        return true;
    }
}
