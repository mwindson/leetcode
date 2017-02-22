package Problem001_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mwindson on 2017/2/14.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Problem017 {
    public static void main(String[] args) {
        String digits = "23456";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> letter = new LinkedList<>();
        combinations("", digits, letter, 0);
        return letter;
    }

    private static void combinations(String prefix, String digits, List<String> letter, int offset) {
        if (digits.length() == 0) {
            if (prefix != "")
                letter.add(prefix);
            return;
        }
        char[][] digitMap = {
                {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        int x = digits.charAt(0) - '0';
        for (char c : digitMap[x]) {
            combinations(prefix + c, digits.substring(1), letter, offset);
        }
    }

}
