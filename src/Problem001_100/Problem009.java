package Problem001_100;

/**
 * Created by mwindson on 2017/2/1.
 * Question: https://leetcode.com/problems/palindrome-number/
 */
public class Problem009 {
    public static void main(String[] args) {
        int num = 1534236469;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int p = x;
        int q = 0;
        while (p >= 10) {
            q *= 10;
            q += p % 10;
            p /= 10;
        }

        return q == x / 10 && p == x % 10;
    }
}
