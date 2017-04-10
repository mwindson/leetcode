package Problem301_400;

/**
 * Created by mwindson on 2017/4/10.
 * https://leetcode.com/problems/nth-digit/#/description
 */
public class Problem400 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(189));
    }

    public static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
