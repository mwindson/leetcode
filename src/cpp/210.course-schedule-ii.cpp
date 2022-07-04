/*
 * @lc app=leetcode id=210 lang=cpp
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (46.81%)
 * Likes:    7101
 * Dislikes: 244
 * Total Accepted:    653.3K
 * Total Submissions: 1.4M
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
 * Return the ordering of courses you should take to finish all courses. If
 * there are many valid answers, return any of them. If it is impossible to
 * finish all courses, return an empty array.
 *
 *
 * Example 1:
 *
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1].
 *
 *
 * Example 2:
 *
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both courses 1 and 2. Both courses 1 and 2 should be
 * taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3].
 *
 *
 * Example 3:
 *
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites) {
    vector<vector<int>> graph(numCourses, vector<int>(numCourses, 0));
    vector<int> degree(numCourses);
    for (auto &prerequisite : prerequisites) {
      int a = prerequisite[0];
      int b = prerequisite[1];
      graph[b][a] = 1;
      degree[a]++;
    }

    vector<int> orders;
    deque<int> q;
    for (int i = 0; i < numCourses; i++) {
      if (degree[i] == 0) {
        q.push_back(i);
      }
    }
    while (!q.empty()) {
      int curr = q.front();
      q.pop_front();
      orders.emplace_back(curr);
      for (int i = 0; i < numCourses; i++) {
        if (graph[curr][i] == 1) {
          graph[curr][i] = 0;
          degree[i]--;
          if (degree[i] == 0) {
            q.push_back(i);
          }
        }
      }
    }
    for (int i = 0; i < numCourses; i++) {
      if (degree[i] != 0) {
        return vector<int>();
      }
    }

    return orders;
  }
};
// @lc code=end
