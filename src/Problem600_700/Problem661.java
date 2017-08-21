package Problem600_700;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/8/21.
 * https://leetcode.com/problems/image-smoother/description/
 */
public class Problem661 {
    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
        };
        System.out.println(Arrays.deepToString(imageSmoother(M)));
    }

    public static int[][] imageSmoother(int[][] M) {
        if (M.length == 0) return M;
        int[][] res = new int[M.length][M[0].length];
        int[][] d = {{-1, 0, 1}, {-1, 0, 1}};
        for (int j = 0; j < M.length; j++) {
            for (int i = 0; i < M[0].length; i++) {
                int sum = 0;
                int count = 0;
                for (int dj : d[0]) {
                    for (int di : d[1]) {
                        if (i + di < M[0].length && i + di >= 0 && j + dj < M.length && j + dj >= 0) {
                            sum += M[j + dj][i + di];
                            count++;
                        }
                    }
                }
                res[j][i] = sum / count;
            }
        }
        return res;
    }
}
