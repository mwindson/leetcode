/*
 * @lc app=leetcode id=399 lang=cpp
 *
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (58.76%)
 * Likes:    6039
 * Dislikes: 506
 * Total Accepted:    290.3K
 * Total Submissions: 492.4K
 * Testcase Example:  '[["a","b"],["b","c"]]\n' +
  '[2.0,3.0]\n' +
  '[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * j^th query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 *
 *
 * Example 1:
 *
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 *
 * Example 2:
 *
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values =
 * [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 *
 * Example 3:
 *
 *
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<double> calcEquation(vector<vector<string>> &equations,
                              vector<double> &values,
                              vector<vector<string>> &queries) {
    unordered_map<string, vector<string>> graph;
    unordered_map<string, double> eq_vals;
    for (int i = 0; i < equations.size(); i++) {
      string a = equations[i][0];
      string b = equations[i][1];
      double val = values[i];
      eq_vals[a + "/" + b] = val;
      eq_vals[b + "/" + a] = 1.0 / val;
      graph[a].emplace_back(b);
      graph[b].emplace_back(a);
    }
    vector<double> res;
    for (vector<string> &query : queries) {
      string a = query[0];
      string b = query[1];
      if (graph.count(a) == 0 || graph.count(b) == 0) {
        res.emplace_back(-1.00);
      } else {
        unordered_map<string, bool> visited;
        bool found = false;
        double val = 1.0;
        dfs(graph, eq_vals, a, b, visited, val, found);
        res.emplace_back(found ? val : -1.0);
      }
    }
    return res;
  }
  void dfs(unordered_map<string, vector<string>> &graph,
           unordered_map<string, double> &eq_vals, const string &curr,
           const string &end, unordered_map<string, bool> &visited, double &val,
           bool &found) {
    if (curr == end) {
      found = true;
      return;
    }
    visited[curr] = true;
    for (string &next : graph[curr]) {
      if (!visited[next] && eq_vals.count(curr + "/" + next) > 0) {
        double originVal = val;
        val *= eq_vals[curr + "/" + next];
        visited[next] = true;
        dfs(graph, eq_vals, next, end, visited, val, found);
        if (!found) {
          visited[next] = false;
          val = originVal;
        } else {
          break;
        }
      }
    }
  }
};
// @lc code=end
