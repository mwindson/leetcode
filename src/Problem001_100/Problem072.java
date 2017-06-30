package Problem001_100;

import java.util.Map;

/**
 * Created by mwindson on 2017/6/29.
 * https://leetcode.com/problems/edit-distance/#/solutions
 */
public class Problem072 {
    public static void main(String[] args) {
        String word1 = "hiter", word2 = "foolish";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] cost = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            cost[i][0] = i;
        for (int j = 0; j <= len2; j++)
            cost[0][j] = j;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cost[i][j] = cost[i - 1][j - 1];
                else
                    cost[i][j] = Math.min(cost[i - 1][j], Math.min(cost[i][j - 1], cost[i - 1][j - 1])) + 1;
            }
        }
        return cost[len1][len2];
    }
}
