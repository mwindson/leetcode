package Problem201_300;

/**
 * Created by mwindson on 2017/1/31.
 * Questions: https://leetcode.com/problems/ugly-number/
 */
public class Problem263 {
    public static void main(String[] args) {
        System.out.println(isUgly(-1));
    }

    public static boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
