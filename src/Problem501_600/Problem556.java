package Problem501_600;

/**
 * Created by mwindson on 2017/9/5.
 * https://leetcode.com/problems/next-greater-element-iii/description/
 */
public class Problem556 {
    public static void main(String[] args) {
        int n = 1999999999;
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;
        while (i >= 0 && (digits[i] - '0') >= (digits[i + 1] - '0')) {
            i--;
        }
        long result = 0;
        if (i >= 0) {
            int j = digits.length - 1;
            while (j >= i && (digits[j] - '0') <= (digits[i] - '0')) {
                j--;
            }
            swap(digits, i, j);
            reverse(digits, i + 1, digits.length - 1);
            for (char c : digits) {
                result = result * 10 + c - '0';
            }
            if (result > Integer.MAX_VALUE) {
                result = -1;
            }
        } else {
            result = -1;
        }
        return (int) result;
    }

    private static void swap(char[] digits, int i, int j) {
        char tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
    }

    private static void reverse(char[] digits, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }
}
