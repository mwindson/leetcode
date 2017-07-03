package Problem600_700;

/**
 * Created by mwindson on 2017/7/3.
 * https://leetcode.com/problems/sum-of-square-numbers/#/description
 */
public class Problem633 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(judgeSquareSum(i));
        }
    }

    public static boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c / 2); i++) {
            int j = (int) Math.sqrt((c - i * i));
            if (c == j * j + i * i)
                return true;
        }
        return false;
    }
}
