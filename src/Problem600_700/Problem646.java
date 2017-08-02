package Problem600_700;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mwindson on 2017/8/1.
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class Problem646 {
    public static void main(String[] args) {
        int[][] pairs = {{1, 4}, {2, 3}, {4, 10}, {5, 6}, {7, 9}, {8, 10}};
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int i, j, max = 0, n = pairs.length;
        int[] dp = new int[n];
        for (i = 0; i < n; i++) dp[i] = 1;
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }
}
