package Problem600_700;

/**
 * Created by mwindson on 2017/8/1.
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class Problem650 {
    public static void main(String[] args) {
        System.out.println(minSteps(10));
    }

    public static int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n = n / i;
            }
        }
        return res;
    }
}
