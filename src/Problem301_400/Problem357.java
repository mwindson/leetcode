package Problem301_400;

/**
 * Created by mwindson on 2017/2/13.
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class Problem357 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countNumbersWithUniqueDigits(n));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }
}
