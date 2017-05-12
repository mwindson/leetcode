package Problem301_400;

/**
 * Created by mwindson on 2017/5/12.
 * https://leetcode.com/problems/coin-change/#/description
 */
public class Problem322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 17;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i - coins[j]] != -1) {
                        if (dp[i] != -1) {
                            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        } else {
                            dp[i] = dp[i - coins[j]] + 1;
                        }
                    }
                }
            }
        }
        return dp[amount];
    }
}
