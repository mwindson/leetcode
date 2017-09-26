package Problem001_100;

/**
 * Created by mwindson on 2017/8/31.
 * https://leetcode.com/problems/divide-two-integers/description/
 */
public class Problem029 {
    public static void main(String[] args) {
        int dividend = 1;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldividend == 0 || ldividend < ldivisor) return 0;

        long ret = ldivide(ldividend, ldivisor);
        if (ret > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return (int) (sign * ret);
        }
    }

    private static long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
