package Problem401_500;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mwindson on 2017/9/1.
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 */
public class Problem406 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int[] person : people) tmp.add(person[1], new int[]{person[0], person[1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }
}
