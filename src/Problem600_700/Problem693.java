package Problem600_700;

/**
 * Created by mwindson on 2017/10/9.
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 */
public class Problem693 {
    public static void main(String[] args) {
        int n = 22;
        System.out.println(hasAlternatingBits(n));
    }

    public static boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
