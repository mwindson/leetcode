/*
 * @lc app=leetcode id=684 lang=cpp
 *
 * [684] Redundant Connection
 *
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * algorithms
 * Medium (61.30%)
 * Likes:    4027
 * Dislikes: 305
 * Total Accepted:    215.7K
 * Total Submissions: 350.5K
 * Testcase Example:  '[[1,2],[1,3],[2,3]]'
 *
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to
 * n, with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi]
 * indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of
 * n nodes. If there are multiple answers, return the answer that occurs last
 * in the input.
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 *
 * Example 2:
 *
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 *
 * Constraints:
 *
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> findRedundantConnection(vector<vector<int>> &edges) {
    vector<int> union_find(edges.size() + 1, 0);
    vector<int> res;
    for (int i = 0; i < union_find.size(); i++) {
      union_find[i] = i;
    }
    for (int i = 0; i < edges.size(); i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      if (isConnected(union_find, a, b)) {
        res.emplace_back(a);
        res.emplace_back(b);
        break;
      } else {
        connect(union_find, a, b);
      }
    }
    return res;
  }
  int find(vector<int> &union_find, int edge) {
    if (union_find[edge] != edge) {
      union_find[edge] = find(union_find, union_find[edge]);
    }
    return union_find[edge];
  }
  bool isConnected(vector<int> &union_find, int a, int b) {
    return find(union_find, a) == find(union_find, b);
  }
  void connect(vector<int> &union_find, int a, int b) {
    int i = find(union_find, a);
    int j = find(union_find, b);
    union_find[i] = j;
  }
};
// @lc code=end
