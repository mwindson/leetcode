/*
 * @lc app=leetcode id=310 lang=cpp
 *
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 * algorithms
 * Medium (38.15%)
 * Likes:    5678
 * Dislikes: 235
 * Total Accepted:    211.8K
 * Total Submissions: 552.9K
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * A tree is an undirected graph in which any two vertices are connected by
 * exactly one path. In other words, any connected graph without simple cycles
 * is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1
 * edges where edges[i] = [ai, bi] indicates that there is an undirected edge
 * between the two nodes ai and bi in the tree, you can choose any node of the
 * tree as the root. When you select a node x as the root, the result tree has
 * height h. Among all possible rooted trees, those with minimum height (i.e.
 * min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any
 * order.
 *
 * The height of a rooted tree is the number of edges on the longest downward
 * path between the root and a leaf.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node
 * with label 1 which is the only MHT.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 2 * 10^4
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * All the pairs (ai, bi) are distinct.
 * The given input is guaranteed to be a tree and there will be no repeated
 * edges.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges) {
    vector<int> roots;
    if (n == 0) {
      return roots;
    }
    if (n == 1) {
      return {0};
    }
    vector<unordered_set<int>> graph(n);
    for (auto &edge : edges) {
      graph[edge[0]].insert(edge[1]);
      graph[edge[1]].insert(edge[0]);
    }
    queue<int> q;
    for (int i = 0; i < n; i++) {
      if (graph[i].size() == 1) {
        q.push(i);
      }
    }
    while (n > 2) {
      int size = q.size();
      n -= size;
      for (int i = 0; i < size; i++) {
        int node = q.front();
        q.pop();
        for (auto adj : graph[node]) {
          graph[adj].erase(node);
          if (graph[adj].size() == 1) {
            q.push(adj);
          }
        }
      }
    }
    while (!q.empty()) {
      roots.push_back(q.front());
      q.pop();
    }
    return roots;
  }
};
// @lc code=end
