package Problem101_200;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/reverse-words-in-a-string/#/description
 */
public class Problem151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("    "));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
