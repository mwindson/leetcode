package Problem600_700;

/**
 * 600. Non-negative Integers without Consecutive Ones
 * https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/description/
 */
public class Problem600 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(findIntegers(num));
    }

    public static int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();
        int[] a = new int[n];// a[i] 以0结尾长度为i的二进制数个数
        int[] b = new int[n];// a[i] 以1结尾长度为i的二进制数个数
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        int result = a[n - 1] + b[n - 1];
        //when there are two consecutive ones, other integers will be less than it, stop!
        //Third, if we met 01, according to the dp formula,
        // the number of qualified integers for first 0 should be 00 and 01, both of them are less than or equal to 01. The same for 10.
        //Finally, for 00, the number of qualified integers for first 0 should be 00 and 01, but 01 is greater than 00, we should subtract it.
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }
        return result;
    }
}
