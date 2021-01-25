package solutions.java;
/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArray = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArray[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArray[i - 1] += ansArray[i] / 10;
            ansArray[i] %= 10;
        }
        int index = ansArray[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while (index < m + n) {
            sb.append(ansArray[index]);
            index++;
        }
        return sb.toString();
        // String res = "0";
        // for (int i = 0; i < num1.length(); i++) {
        // int digit = num1.charAt(num1.length() - 1 - i) - '0';
        // res = this.add(res, this.mul(digit, i, num2));
        // }
        // for (int i = 0; i < res.length(); i++) {
        // char c = res.charAt(i);
        // if (c != '0' || i == res.length() - 1) {
        // res = res.substring(i);
        // break;
        // }
        // }
        // return res;
    }

    String mul(int digit, int bit, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bit; i++) {
            sb.append('0');
        }
        int carryBit = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            int res = d * digit + carryBit;
            carryBit = res / 10;
            res = res % 10;
            sb.append(res);
        }
        if (carryBit > 0) {
            sb.append(carryBit);
        }
        return sb.reverse().toString();
    }

    String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carryBit = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            char ca = i >= a.length() ? '0' : a.charAt(a.length() - 1 - i);
            char cb = i >= b.length() ? '0' : b.charAt(b.length() - 1 - i);
            int sum = (ca - '0') + (cb - '0') + carryBit;
            carryBit = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }
        if (carryBit > 0) {
            sb.append(carryBit);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        System.out.println(new Solution().multiply(a, b));
    }
}
// @lc code=end
