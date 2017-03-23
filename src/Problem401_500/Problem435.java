package Problem401_500;

import Util.Interval;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mwindson on 2017/3/23.
 * https://leetcode.com/problems/non-overlapping-intervals/#/description
 */
public class Problem435 {
    public static void main(String[] args) {
        int[][] nums = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        Interval[] intervals = Interval.arraysToIntervalsArray(nums);
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (o1, o2) -> (o1.end - o2.end));
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i].start) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}

