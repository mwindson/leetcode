package Problem001_100;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Problem005 {
    public static String longestPalindrome(String s) {
        String LongestS = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                LongestS = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                LongestS = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return LongestS;
    }

    public static boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "babad";
        System.out.print(longestPalindrome(input));
    }
}
