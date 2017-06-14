package Problem401_500;

import Util.Interval;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mwindson on 2017/6/14.
 * https://leetcode.com/problems/find-right-interval/#/solutions
 */
public class Problem436 {
    public static void main(String[] args) {
        int[][] arrays = {{3, 4}, {2, 3}, {1, 2}};
        Interval[] intervals = Interval.arraysToIntervalsArray(arrays);
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = entry == null ? -1 : entry.getValue();
        }
        return result;
    }
}
