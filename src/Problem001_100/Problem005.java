package Problem001_100;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Problem005 {
    public static String longestPalindrome(String s) {
        int length = s.length();
        StringBuffer sb   = new StringBuffer(s);
        int maxlength = 0;
        sb.reverse();
        String LongestS = null;
        String ns = sb.toString();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String subString = s.substring(i, j);
                if (ns.contains(subString)) {
                    if (maxlength < subString.length()) {
                        LongestS = subString;
                        maxlength=LongestS.length();
                    }
                }
            }
        }
        return LongestS;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.print(longestPalindrome(input));
    }
}
