package Problem600_700;

/**
 * Created by mwindson on 2017/9/4.
 * https://leetcode.com/problems/bulb-switcher-ii/description/
 */
public class Problem672 {
    public static void main(String[] args) {
        int n = 3, m = 1;
        System.out.println(flipLights(n, m));
    }

    // a+b+c+d=m
    // a,b,c,d为偶数时，结果不变
    // b和c相当于操作a一次
    public static int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 2;
        if (n == 2 && m == 1) return 3;
        if (n == 2) return 4;
        if (m == 1) return 4;
        if (m == 2) return 7;
        if (m >= 3) return 8;
        return 8;
    }
}
