package Problem501_600;

/**
 * Created by mwindson on 2017/4/10.
 * https://leetcode.com/problems/perfect-number/#/description
 */
public class Problem507 {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(0));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;

        return sum == num;
    }
}
