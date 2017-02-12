package Problem001_100;

import Util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mwindson on 2017/2/12.
 * https://leetcode.com/problems/merge-intervals/
 */
public class Problem056 {
    public static void main(String[] args) {
        int[][] nums = {};
        List<Interval> intervals = Interval.arraysToIntervals(nums);
        System.out.println(merge(intervals));
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        List<Interval> result = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int i = 0;
        Interval interval = null;
        while (i < intervals.size()) {
            if (interval == null) {
                interval = intervals.get(i);
            } else {
                if (interval.end < intervals.get(i).start) {
                    result.add(interval);
                    interval = intervals.get(i);
                } else {
                    interval.start = Math.min(interval.start, intervals.get(i).start);
                    interval.end = Math.max(interval.end, intervals.get(i).end);
                }
            }

            i++;
        }
        result.add(interval);
        return result;
    }
}
