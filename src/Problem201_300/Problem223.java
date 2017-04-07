package Problem201_300;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/4/5.
 * https://leetcode.com/problems/rectangle-area/#/description
 */
public class Problem223 {
    public static void main(String[] args) {
        System.out.println(computeArea(-2,
                -2,
                2,
                2,
                -2,
                -2,
                2,
                2));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfSqrA = (C - A) * (D - B);
        int areaOfSqrB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if (right > left && top > bottom)
            overlap = (right - left) * (top - bottom);

        return areaOfSqrA + areaOfSqrB - overlap;
    }
}
