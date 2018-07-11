package nowcoder;

public class P52 {
    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;

        for (int i = str.length; i >= 0; i--) {
            for (int j = pattern.length - 1; j >= 0; j--) {
                boolean first_match = i < str.length && (pattern[j] == str[i] || pattern[j] == '.');
                if (j < pattern.length - 1 && pattern[j + 1] == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
