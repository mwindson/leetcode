package Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/2/12.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static List<Interval> arraysToIntervals(int[][] arrays) {
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            intervals.add(new Interval(arrays[i][0], arrays[i][1]));
        }
        return intervals;
    }
}
