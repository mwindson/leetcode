package Problem101_200;

/**
 * Created by mwindson on 2017/7/4.
 * https://leetcode.com/problems/palindrome-partitioning-ii/#/description
 */
public class Problem132 {
    public static void main(String[] args) {
        String s = "aabacbca";
        System.out.println(minCut(s));
    }

    // cut[i]=cut[j-1]+1, (j,i) is palindrome
    // (j,i) is palindrome =>  (j+1,i-1)is palindrome and c[i]=c[j]
    public static int minCut(String s) {
        // min cut counts from 0 to i
        int[] cut = new int[s.length()];
        char[] c = s.toCharArray();
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                // 上个步骤为回文或者只有单个字符
                if (c[i] == c[j] && (i - j < 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[s.length() - 1];
    }
// another method
//    public static int minCut(String s) {
//        int n = s.length();
//        int[] cut = new int[n + 1];
//        for (int i = 0; i <= n; i++) cut[i] = i - 1;
//        // i:the center of palindrome,j: the length of half  palindrome
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) // odd length palindrome
//                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
//
//            for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++) // even length palindrome
//                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
//        }
//        return cut[n];
//    }
}
