package Problem201_300;

/**
 * Created by mwindson on 2017/3/18.
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/#/description
 */
public class Problem201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return m & n;
    }
}
