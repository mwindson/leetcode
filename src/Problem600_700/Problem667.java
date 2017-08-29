package Problem600_700;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/8/29.
 * https://leetcode.com/problems/beautiful-arrangement-ii/description/
 */
public class Problem667 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(10, 4)));
    }

    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : (k % 2 != 0 ? l++ : r--);
        return res;
    }
}
