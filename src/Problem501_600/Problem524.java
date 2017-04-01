package Problem501_600;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/4/1.
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/#/description
 */
public class Problem524 {
    public static void main(String[] args) {
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> d = Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf");
        System.out.println(findLongestWord(s, d));
    }

    public static String findLongestWord(String s, List<String> d) {
        char[] dict = s.toCharArray();
        int maxLength = 0;
        String longestWord = "";
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).length() >= maxLength) {
                boolean canFind = true;
                char[] word = d.get(i).toCharArray();
                int m = 0, n = 0;
                while (m < word.length && n < dict.length) {
                    if (word[m] == dict[n]) {
                        m++;
                        n++;
                    } else {
                        n++;
                    }
                }
                if (m != word.length) {
                    canFind = false;
                }
                if (canFind) {
                    if (word.length > maxLength) {
                        maxLength = word.length;
                        longestWord = d.get(i);
                    } else {
                        if (d.get(i).compareTo(longestWord) < 0)
                            longestWord = d.get(i);
                    }
                }
            }
        }
        return longestWord;
    }
}
