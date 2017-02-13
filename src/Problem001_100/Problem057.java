package Problem001_100;

import Util.Interval;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mwindson on 2017/2/12.
 * https://leetcode.com/problems/insert-interval/
 */
public class Problem057 {
    public static void main(String[] args) {
        int[][] nums = {};
        Interval newInterval = new Interval(4,5);
        System.out.println(insert(Interval.arraysToIntervals(nums), newInterval));
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newIntervals = new LinkedList<>();
        int i = 0;
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            if (curr.start <= newInterval.start) {
                if (curr.end < newInterval.start) {
                    newIntervals.add(curr);

                } else {
                    newInterval.start = Math.min(curr.start, newInterval.start);
                    newInterval.end = Math.max(curr.end, newInterval.end);
                }
            } else {
                if (curr.start > newInterval.end) {
                    newIntervals.add(newInterval);
                    newInterval = curr;
                } else {
                    newInterval.start = Math.min(curr.start, newInterval.start);
                    newInterval.end = Math.max(curr.end, newInterval.end);
                }
            }
            i++;
        }

        newIntervals.add(newInterval);
        return newIntervals;
    }
}
