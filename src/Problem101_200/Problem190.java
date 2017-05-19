package Problem101_200;

/**
 * Created by mwindson on 2017/5/19.
 * https://leetcode.com/problems/reverse-bits/#/description
 */
public class Problem190 {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
