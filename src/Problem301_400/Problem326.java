package Problem301_400;

/**
 * Created by mwindson on 2017/1/31.
 * Question: https://leetcode.com/problems/power-of-three/
 */
public class Problem326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
    public static boolean isPowerOfThree(int n) {
        return n != 0 && n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}
