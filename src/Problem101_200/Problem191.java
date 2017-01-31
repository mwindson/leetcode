package Problem101_200;

/**
 * Created by mwindson on 2017/1/31.
 * Question; https://leetcode.com/problems/number-of-1-bits/
 */
public class Problem191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-27));
    }
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
