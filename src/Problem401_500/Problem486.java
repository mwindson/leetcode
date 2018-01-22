package Problem401_500;

/**
 * Created by mwindson on 2018/1/22.
 * https://leetcode.com/problems/predict-the-winner/description/
 */
public class Problem486 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] maxScore = new int[n][n]; // [i,j]的先手最大分数
        int[] sum = new int[n + 1]; // [0,i-1]的分数和
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            maxScore[i][i] = nums[i];
        }
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                maxScore[i][j] = (sum[j + 1] - sum[i]) - Math.min(maxScore[i + 1][j], maxScore[i][j - 1]);
            }
        }
        return maxScore[0][n - 1] >= (sum[n] - maxScore[0][n - 1]);
    }
}
