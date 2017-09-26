package Problem001_100;

/**
 * Created by mwindson on 2017/9/7.
 * https://leetcode.com/problems/scramble-string/description/
 */
public class Problem087 {
    public static void main(String[] args) {
        System.out.println(isScramble("rgtae", "great"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        // dp[i][j][k]: s1(i,i+k-1) is scramble string of s2(j,j+k-1) or not
        boolean[][][] dp = new boolean[len][len][len + 1];
        for (int k = 1; k <= len; k++) {
            for (int i = 0; i + k <= len; i++) {
                for (int j = 0; j + k <= len; j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int q = 1; q < k && !dp[i][j][k]; ++q) {
                            // s1(i,i+q), s2(j,j+q) and s1(i+q,i+k),s2(j+q,j+k) 顺序相同
                            // s1(i,i+q), s2(j+k-q,j+k) and s1(i+q,i+k), s2(j,j+k-q) 顺序相反
                            dp[i][j][k] = (dp[i][j][q] && dp[i + q][j + q][k - q]) || (dp[i][j + k - q][q] && dp[i + q][j][k - q]);
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}
