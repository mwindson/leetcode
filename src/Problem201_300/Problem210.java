package Problem201_300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by mwindson on 2017/5/11.
 * https://leetcode.com/problems/course-schedule-ii/#/description
 */
public class Problem210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {0, 1}, {3, 2}};
        System.out.println(findOrder(numCourses, prerequisites));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        // 初始化图
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        // 初始化degree和对应课程
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                order[numCourses - 1 - count] = i;
                count++;
            }
        }
        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph.get(course).size(); i++) {
                int next = (int) graph.get(course).get(i);
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                    order[numCourses - 1 - count] = next;
                    count++;
                }
            }
        }
        if (numCourses != count) {
            order = new int[]{};
        }
        return order;
    }
}
