/*
 * @lc app=leetcode id=207 lang=cpp
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (45.10%)
 * Likes:    9965
 * Dislikes: 403
 * Total Accepted:    914.7K
 * Total Submissions: 2M
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i]
 * = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 *
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 * Example 1:
 *
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 *
 * Example 2:
 *
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool canFinish(int numCourses, vector<vector<int>> &prerequisites) {
    unordered_map<int, set<int>> prev;
    unordered_map<int, set<int>> next;
    vector<int> degree(numCourses, 0);
    for (auto &courses : prerequisites) {
      int a = courses[0];
      int b = courses[1];
      if (prev.count(b) == 0) {
        set<int> vec;
        prev[b] = vec;
      }
      if (next.count(a) == 0) {
        set<int> vec;
        next[a] = vec;
      }
      prev[b].insert(a);
      next[a].insert(b);

      degree[b] = prev[b].size();
    }
    deque<int> q;
    for (int i = 0; i < numCourses; i++) {
      if (degree[i] == 0) {
        q.push_back(i);
      }
    }
    while (!q.empty()) {
      int curr = q.front();
      q.pop_front();
      if (next.count(curr) > 0) {
        for (int n : next[curr]) {
          prev[n].erase(curr);
          degree[n]--;
          if (prev[n].size() == 0) {
            q.push_back(n);
            prev.erase(n);
          }
        }
      }
    }
    for (int i = 0; i < numCourses; i++) {
      if (degree[i] != 0) {
        return false;
      }
    }

    return true;
  }
};
// @lc code=end
