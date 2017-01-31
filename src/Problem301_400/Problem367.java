package Problem301_400;

/**
 * Created by mwindson on 2017/1/31.
 * Question: https://leetcode.com/problems/valid-perfect-square/
 */
public class Problem367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
    }

    // n^2=1+3+5+7+....+2n-1
    public static boolean isPerfectSquare(int num) {
//        if (num <= 0) return false;
//        int sum = 0;
//        for (int i = 1; i <= num / 2 + 1; i += 2) {
//            sum += i;
//            if (sum >= num) break;
//        }
//        return sum == num;
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
