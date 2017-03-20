package Problem401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/20.
 * https://leetcode.com/problems/keyboard-row/#/description
 */
public class Problem500 {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(findWords(words));
    }

    public static String[] findWords(String[] words) {
        List<String> wordsMatch = new ArrayList<>();
        String regex1 = "[qwertyuiopQWERTYUIOP]+";
        String regex2 = "[asdfghjklASDFGHJKL]+";
        String regex3 = "[zxcvbnmZXCVBNM]+";
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches(regex1)||words[i].matches(regex2)||words[i].matches(regex3)) {
                wordsMatch.add(words[i]);
            }
        }
        String[] res = new String[wordsMatch.size()];
        return wordsMatch.toArray(res);
    }
}
