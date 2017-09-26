package Problem301_400;

/**
 * Created by mwindson on 2017/9/1.
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 */
public class Problem316 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        boolean[] letter = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!letter[c - 'a']) {
                letter[c - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (letter[i]) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
