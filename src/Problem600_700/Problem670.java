package Problem600_700;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mwindson on 2017/9/4.
 * https://leetcode.com/problems/maximum-swap/description/
 */
public class Problem670 {
    public static void main(String[] args) {
        int num = 93467;
        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
