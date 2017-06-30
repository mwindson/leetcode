package Problem501_600;

/**
 * Created by mwindson on 2017/6/30.
 * https://leetcode.com/problems/longest-palindromic-subsequence/#/description
 */
public class Problem516 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    // dp[i][j]:(i,j)范围内的最长回文序列
    // initialization dp[i][i]=1
    // s[i]==s[j] => dp[i][j]=d[i+1][j-1]+2;
    // else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
    public static int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        // 从左下角到右上角进行遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
}
