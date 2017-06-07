package Problem501_600;

/**
 * Created by mwindson on 2017/6/6.
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/#/solutions
 */
public class Problem521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
