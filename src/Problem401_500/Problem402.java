package Problem401_500;

/**
 * Created by mwindson on 2017/9/26.
 * https://leetcode.com/problems/remove-k-digits/description/
 */
public class Problem402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 2;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        if (k > num.length()) return "0";
        int remain = num.length() - k;
        char[] chars = new char[remain];
        int len = 0;
        for (int i = 0; i < num.length(); i++) {
            while (len > 0 && len + (num.length() - i) > remain && chars[len - 1] > num.charAt(i)) {
                len--;
            }
            if (len < remain)
                chars[len++] = num.charAt(i);
        }
        StringBuilder result = new StringBuilder();
        int start = 0;
        while (start < chars.length && chars[start] == '0') start++;
        if (start == chars.length) return "0";
        for (int i = start; i < chars.length; i++) {
            result.append(chars[i]);
        }
        return result.toString();
    }
}
