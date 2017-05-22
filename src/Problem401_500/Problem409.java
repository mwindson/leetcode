package Problem401_500;

import java.util.HashSet;

/**
 * Created by Administrator on 2016/12/16.
 */
public class Problem409 {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.print(longestPalindrome(s));
    }

    //built with those letters. 可以重排！！！
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}
