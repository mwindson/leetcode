package Problem001_100;

/**
 * Created by mwindson on 2017/3/24.
 * https://leetcode.com/problems/sqrtx/#/description
 */
public class Problem069 {
    public static void main(String[] args) {
        System.out.println(mySqrt(13));
    }

    public static int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}
