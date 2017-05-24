package Problem501_600;

/**
 * Created by mwindson on 2017/5/24.
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description
 */
public class Problem557 {
    public static void main(String[] args) {
        String s = "Let's  take  LeetCode   contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder wordsReverse = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            wordsReverse.append(new StringBuilder(words[i]).reverse());
            wordsReverse.append(" ");
        }
        return wordsReverse.substring(0, wordsReverse.length() - 1);
    }
}
