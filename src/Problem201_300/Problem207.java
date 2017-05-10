package Problem201_300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by mwindson on 2017/4/5.
 * https://leetcode.com/problems/course-schedule/#/description
 */
public class Problem207 {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{0, 1}, {1, 0}, {1, 3}, {2, 4}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    // 判断图有无环，即拓扑顺序是否存在
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        // 初始化degree和对应课程
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
