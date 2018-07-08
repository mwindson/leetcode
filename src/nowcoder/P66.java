package nowcoder;

public class P66 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0) return 0;
        boolean[][] dp = new boolean[rows][cols];
        dp[0][0] = true;
        int count = 1;
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] && getSum(i) <= threshold;
            count += dp[i][0] ? 1 : 0;
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] && getSum(j) <= threshold;
            count += dp[0][j] ? 1 : 0;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]) && (getSum(i) + getSum(j) <= threshold);
                count += dp[i][j] ? 1 : 0;
            }
        }
        return count;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
