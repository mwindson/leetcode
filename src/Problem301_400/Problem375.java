package Problem301_400;

/**
 * Created by mwindson on 2017/6/21.
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/#/description
 */
public class Problem375 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getMoneyAmount(i));
        }
    }

    public static int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(table[i][k - 1], table[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        return table[1][n];
    }
}
