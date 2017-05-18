package Problem301_400;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/integer-replacement/#/description
 */
public class Problem397 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(100000000));
    }

    public static int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;

            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                // 001=>000
                --n;
            } else {
                // 011=>100 优于011=>010
                ++n;
            }
            ++c;
        }
        return c;
    }
}
