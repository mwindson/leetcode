package Problem600_700;

/**
 * Created by mwindson on 2017/11/16.
 * https://leetcode.com/problems/count-binary-substrings/description/
 */
public class Problem696 {
    public static void main(String[] args) {
        String s = "0011100001";
        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        int[] groups = new int[s.length() + 1];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i - 1], groups[i]);
        }
        return ans;
    }
}
