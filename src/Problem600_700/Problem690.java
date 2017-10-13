package Problem600_700;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/10/5.
 * https://leetcode.com/problems/employee-importance/description/
 */
public class Problem690 {
    public static void main(String[] args) {

    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public static int getImportance(List<Employee> employees, int id) {
        Queue<Integer> queue = new ArrayDeque<>();
        int sum = 0;
        queue.add(id);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Employee employee : employees) {
                if (current == employee.id) {
                    sum += employee.importance;
                    queue.addAll(employee.subordinates);
                }
            }
        }
        return sum;
    }
}
