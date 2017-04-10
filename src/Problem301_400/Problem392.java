package Problem301_400;

/**
 * Created by mwindson on 2017/4/10.
 * https://leetcode.com/problems/is-subsequence/#/description
 */
public class Problem392 {
    public static void main(String[] args) {
        String s = "axc";
        String t = "deahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i >= s.length();
    }
}
