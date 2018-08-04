package nowcoder;

public class P9 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        if (target == 0) return 0;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[target];
    }
}
