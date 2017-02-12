package Problem001_100;

/**
 * Created by mwindson on 2017/2/7.
 * https://leetcode.com/problems/plus-one/
 */
public class Problem066 {
    public static void main(String[] args) {
        int[] num = {0};
        System.out.println(plusOne(num));
    }

    public static int[] plusOne(int[] digits) {
        int carryBit = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carryBit;
            }
            if (sum >= 10) {
                carryBit = 1;
                sum -= 10;
            } else {
                carryBit = 0;
            }
            digits[i] = sum;
        }
        int[] result;
        if (carryBit == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length - 1; i++) {
                result[i + 1] = digits[i];
            }
        } else {
            result = digits;
        }
        return result;
    }
}
