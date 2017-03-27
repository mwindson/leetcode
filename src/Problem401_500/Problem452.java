package Problem401_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mwindson on 2017/3/27.
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/#/description
 */
public class Problem452 {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return 0;
                else
                    return o1[0] > o2[0] ? 1 : -1;
            }
        });
        int start = points[0][0], end = points[0][1];
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                start = points[i][0];
                end = points[i][1];
                count++;
            } else {
                start = points[i][0];
                end = Math.min(end, points[i][1]);
            }
        }
        return count + 1;
    }
}
