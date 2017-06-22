package Problem201_300;

/**
 * Created by mwindson on 2017/6/22.
 * https://leetcode.com/problems/number-of-digit-one/#/solutions
 */
public class Problem233 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1234));
    }

    public static int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }
}
