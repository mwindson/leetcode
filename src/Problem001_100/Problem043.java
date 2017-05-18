package Problem001_100;

import java.util.Objects;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/multiply-strings/#/description
 */
public class Problem043 {
    public static void main(String[] args) {
        String num1 = "1111";
        String num2 = "0";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        String res = "0";
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) return res;
        for (int i = num2.length() - 1; i >= 0; i--) {
            String oneMultiplyResult = multiplyOneChar(num1, num2.charAt(i));
            int count = num2.length() - 1 - i;
            while (count > 0) {
                oneMultiplyResult += '0';
                count--;
            }
            res = add(res, oneMultiplyResult);
        }
        return res;
    }

    private static String multiplyOneChar(String num, char c) {
        StringBuilder sb = new StringBuilder();
        int carryBit = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int res = (num.charAt(i) - '0') * (c - '0') + carryBit;
            carryBit = res / 10;
            sb.append(res % 10);
        }
        if (carryBit != 0)
            sb.append(carryBit);
        return sb.reverse().toString();
    }

    private static String add(String num1, String num2) {
        StringBuilder A = new StringBuilder(num1);
        StringBuilder B = new StringBuilder(num2);
        StringBuilder result = new StringBuilder();
        A.reverse();
        B.reverse();
        int carryBit = 0;
        int len = Math.max(A.length(), B.length());
        for (int i = 0; i < len; i++) {
            int sum = (i >= A.length() ? 0 : A.charAt(i) - '0') + (i >= B.length() ? 0 : B.charAt(i) - '0') + carryBit;
            if (sum >= 10) {
                carryBit = 1;
                sum -= 10;
            } else {
                carryBit = 0;
            }
            result.append(sum);
        }
        if (carryBit == 1)
            result.append(1);
        return result.reverse().toString();
    }
}
