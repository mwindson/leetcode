package Problem501_600;

import java.util.*;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/minimum-time-difference/#/description
 */
public class Problem539 {
    public static void main(String[] args) {
        String[] times = {"23:59", "23:52", "23:49"};
        List<String> timePoints = Arrays.asList(times);
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        int minDifference = 24 * 60;
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int difference = 0;
        for (int i = 0; i < timePoints.size(); i++) {
            if (i == timePoints.size() - 1)
                difference = calDifferecen(timePoints.get(i), timePoints.get(0));
            else
                difference = calDifferecen(timePoints.get(i), timePoints.get(i + 1));
            minDifference = Math.min(minDifference, difference);
        }
        return minDifference;
    }

    private static int calDifferecen(String s1, String s2) {
        String[] times = s1.split(":");
        int time1 = Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
        times = s2.split(":");
        int time2 = Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
        return Math.min(Math.abs(time1 - time2), 24 * 60 - Math.abs(time1 - time2));
    }

}
