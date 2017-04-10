import java.util.Scanner;

/**
 * Created by mwindson on 2017/4/7.
 */
public class Problem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        System.out.format("%.5f", func(n, p));
    }

    public static double func(int n, int[] p) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] * p[i] * 1.0 / 100;
            for (int j = i; j >= 0; j--) {
                if (j != 0) {
                    dp[j] = dp[j] * (1 - p[i] * 1.0 / 100) + dp[j- 1] * p[i] * 1.0 / 100;
                } else {
                    dp[j] = dp[j] * (1 - p[i] * 1.0 / 100);
                }
            }
        }
        double pass = 0.0;
        for (int i = (int) (Math.ceil(n * 0.6)); i <= n; ++i) {
            pass += dp[i];
        }
        pass = Math.ceil(pass * 1e5) / 1e5;
        return pass;
    }
}
