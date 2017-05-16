package Problem301_400;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mwindson on 2017/5/16.
 * https://leetcode.com/problems/water-and-jug-problem/#/description
 */
public class Problem365 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 5));
    }

    // We can always find a and b to satisfy ax + by = d where d = gcd(x, y)
    public static boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (z - x <= y && z % gcd(x, y) == 0);
    }

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
