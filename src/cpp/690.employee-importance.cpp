/*
 * @lc app=leetcode id=690 lang=cpp
 *
 * [690] Employee Importance
 *
 * https://leetcode.com/problems/employee-importance/description/
 *
 * algorithms
 * Medium (64.28%)
 * Likes:    1746
 * Dislikes: 1270
 * Total Accepted:    184K
 * Total Submissions: 283.4K
 * Testcase Example:  '[[1,5,[2,3]],[2,3,[]],[3,3,[]]]\n1'
 *
 * You have a data structure of employee information, including the employee's
 * unique ID, importance value, and direct subordinates' IDs.
 *
 * You are given an array of employees employees where:
 *
 *
 * employees[i].id is the ID of the i^th employee.
 * employees[i].importance is the importance value of the i^th employee.
 * employees[i].subordinates is a list of the IDs of the direct subordinates of
 * the i^th employee.
 *
 *
 * Given an integer id that represents an employee's ID, return the total
 * importance value of this employee and all their direct and indirect
 * subordinates.
 *
 *
 * Example 1:
 *
 *
 * Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 * Output: 11
 * Explanation: Employee 1 has an importance value of 5 and has two direct
 * subordinates: employee 2 and employee 3.
 * They both have an importance value of 3.
 * Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 *
 * Example 2:
 *
 *
 * Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
 * Output: -3
 * Explanation: Employee 5 has an importance value of -3 and has no direct
 * subordinates.
 * Thus, the total importance value of employee 5 is -3.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= employees.length <= 2000
 * 1 <= employees[i].id <= 2000
 * All employees[i].id are unique.
 * -100 <= employees[i].importance <= 100
 * One employee has at most one direct leader and may have several
 * subordinates.
 * The IDs in employees[i].subordinates are valid IDs.
 *
 *
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
  int getImportance(vector<Employee *> employees, int id) {
    unordered_map<int, Employee *> em;
    for (auto *employee : employees) {
      em[employee->id] = employee;
    }
    int total = search(em[id], em);
    return total;
  }
  int search(Employee *e, unordered_map<int, Employee *> &em) {
    int total = e->importance;
    for (int sub_id : e->subordinates) {
      total += search(em[sub_id], em);
    }
    return total;
  }
};
// @lc code=end
