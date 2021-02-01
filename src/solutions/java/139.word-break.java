import java.util.Arrays;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.substring(i - word.length(), i).compareTo(word) == 0) {
                    canSegment[i] = canSegment[i] || canSegment[i - word.length()];
                    if(canSegment[i]) break;
                }
            }
        }
        return canSegment[s.length()];
    }
}
// @lc code=end
