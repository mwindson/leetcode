package Problem501_600;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mwindson on 2017/5/27.
 * https://leetcode.com/problems/fraction-addition-and-subtraction/#/description
 */
public class Problem592 {
    public static void main(String[] args) {
        String expression = "-1/2-1/3+1/4-1/5";
        System.out.println(fractionAddition(expression));
    }

    public static String fractionAddition(String expression) {
        List<String> list = new ArrayList<>();
        String result = "0/1";
        int prev = 0;
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                list.add(expression.substring(prev, i));
                prev = i + 1;
            } else if (expression.charAt(i) == '-') {
                list.add(expression.substring(prev, i));
                prev = i;
            }
        }
        list.add(expression.substring(prev, expression.length()));
        for (String num : list) {
            result = calculate(result, num);
        }

        return result;
    }

    private static String calculate(String a, String b) {
        String[] aString = a.split("/");
        int numA = Integer.valueOf(aString[0]);
        int denA = Integer.valueOf(aString[1]);
        String[] bString = b.split("/");
        int numB = Integer.valueOf(bString[0]);
        int denB = Integer.valueOf(bString[1]);

        int den = denA * denB;
        int num = numA * denB + numB * denA;
        boolean isNegative = den * num < 0;
        num = Math.abs(num);
        den = Math.abs(den);
        int gcd = getGCD(num, den);

        return (isNegative ? "-" : "") + (num / gcd) + "/" + (den / gcd);
    }

    private static int getGCD(int a, int b) {
        if (a == 0 || b == 0) return a + b; // base case
        return getGCD(b, a % b);
    }
}
