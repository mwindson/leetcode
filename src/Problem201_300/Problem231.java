package Problem201_300;

/**
 * Created by mwindson on 2017/1/31.
 * Question: https://leetcode.com/problems/power-of-two/
 */
public class Problem231 {
    public static void main(String[] args) {
        int num = 2048;
        System.out.println(isPowerOfTwo(num));
    }

    public static boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
