package Problem001_100;

/**
 * Created by mwindson on 2017/6/16.
 * https://leetcode.com/problems/regular-expression-matching/#/description
 */
public class Problem010 {
    public static void main(String[] args) {
        String s = "aab", p = ".*";
        System.out.println(isMatch(s, p));
    }

    // '.' Matches any single character.
    // '*' Matches zero or more of the preceding element.
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    //  if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //  if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                        //  dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                        //  dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                        //  dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
