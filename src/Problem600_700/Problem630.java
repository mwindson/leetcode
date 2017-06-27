package Problem600_700;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by mwindson on 2017/6/26.
 * https://leetcode.com/problems/course-schedule-iii/#/description
 */
public class Problem630 {
    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {300, 1000}, {1000, 1600}, {2000, 3000}};
        System.out.println(scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time > c[1])
                time -= pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
        }
        return pq.size();
    }
}
