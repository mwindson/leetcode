package Problem001_100;

/**
 * Created by mwindson on 2017/6/30.
 * https://leetcode.com/problems/interleaving-string/#/description
 */
public class Problem097 {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        // dp[i][j] 从s1中取i个，从s2中取j个，能否构成s3中i+j长度的字符串
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++)
            dp[i][0] = dp[i - 1][0] & s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int j = 1; j <= s2.length(); j++)
            dp[0][j] = dp[0][j - 1] & s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                boolean fromS1 = dp[i][j + 1] & s1.charAt(i) == s3.charAt(i + j + 1);
                boolean fromS2 = dp[i + 1][j] & s2.charAt(j) == s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = fromS1 | fromS2;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
