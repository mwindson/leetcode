package Problem401_500;

/**
 * Created by mwindson on 2017/7/4.
 * https://leetcode.com/problems/longest-repeating-character-replacement/#/description
 */
public class Problem424 {
    public static void main(String[] args) {
        String s = "";
        int k = 0;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            // 不符合条件，窗口滑动
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
