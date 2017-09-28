package Problem301_400;

/**
 * Created by mwindson on 2017/9/28.
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class Problem395 {
    public static void main(String[] args) {
        String s = "ababbceeedffggh";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private static int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
