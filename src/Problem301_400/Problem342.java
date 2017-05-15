package Problem301_400;

/**
 * Created by mwindson on 2017/5/12.
 * https://leetcode.com/problems/power-of-four/#/description
 */
public class Problem342 {
    public static void main(String[] args) {
        for (int i = 4; i <= 17; i++) {
            System.out.println(isPowerOfFour(i));
        }
    }

    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
