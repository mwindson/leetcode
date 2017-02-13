package Problem001_100;

/**
 * Created by mwindson on 2017/2/13.
 * https://leetcode.com/problems/powx-n/
 */
public class Problem050 {
    public static void main(String[] args) {
        double x = 2.3;
        int n = -4;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        double factor = x;
        factor = myPow(factor, n / 2);
        if (n % 2 == 0) {
            return factor * factor;
        } else {
            if (n > 0) {
                return factor * factor * x;
            } else {
                return (factor * factor) / x;
            }
        }
    }
}
