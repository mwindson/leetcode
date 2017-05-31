package Problem501_600;

/**
 * Created by mwindson on 2017/5/31.
 * https://leetcode.com/problems/range-addition-ii/#/description
 */
public class Problem598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            minRow = Math.min(minRow, ops[i][0]);
            minCol = Math.min(minCol, ops[i][1]);
        }
        minRow = Math.min(minRow, m);
        minCol = Math.min(minCol, n);
        return minCol * minRow;
    }
}
