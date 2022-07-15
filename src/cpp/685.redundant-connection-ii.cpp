/*
 * @lc app=leetcode id=685 lang=cpp
 *
 * [685] Redundant Connection II
 *
 * https://leetcode.com/problems/redundant-connection-ii/description/
 *
 * algorithms
 * Hard (33.84%)
 * Likes:    1704
 * Dislikes: 273
 * Total Accepted:    54.5K
 * Total Submissions: 160.5K
 * Testcase Example:  '[[1,2],[1,3],[2,3]]'
 *
 * In this problem, a rooted tree is a directed graph such that, there is
 * exactly one node (the root) for which all other nodes are descendants of
 * this node, plus every node has exactly one parent, except for the root node
 * which has no parents.
 *
 * The given input is a directed graph that started as a rooted tree with n
 * nodes (with distinct values from 1 to n), with one additional directed edge
 * added. The added edge has two different vertices chosen from 1 to n, and was
 * not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges
 * is a pair [ui, vi] that represents a directed edge connecting nodes ui and
 * vi, where ui is a parent of child vi.
 *
 * Return an edge that can be removed so that the resulting graph is a rooted
 * tree of n nodes. If there are multiple answers, return the answer that
 * occurs last in the given 2D-array.
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
 * Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * Output: [4,1]
 *
 *
 *
 * Constraints:
 *
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 *
 *
 */

// @lc code=start
class Solution {
public:
  struct UnionFind {
    vector<int> fa;
    UnionFind(int n) {
      for (int i = 0; i <= n; i++) {
        fa.emplace_back(i);
      }
    }
    int find(int i) {
      if (fa[i] != i) {
        fa[i] = find(fa[i]);
      }
      return fa[i];
    }
    void connect(int a, int b) {
      int i = find(a);
      int j = find(b);
      fa[i] = j;
    }
    bool isConnected(int a, int b) { return find(a) == find(b); }
  };
  vector<int> findRedundantDirectedConnection(vector<vector<int>> &edges) {
    vector<int> parent(edges.size() + 1, 0);
    UnionFind uf(edges.size() + 1);
    int edgeRemoved = -1, edgeMakesCycle = -1;
    for (int i = 0; i < edges.size(); i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      if (parent[b] != 0) {
        edgeRemoved = i;
        break;
      } else {
        parent[b] = a;
      }
    }
    for (int i = 0; i < edges.size(); i++) {
      if (i == edgeRemoved) {
        continue;
      }
      int a = edges[i][0];
      int b = edges[i][1];

      if (uf.isConnected(a, b)) {
        edgeMakesCycle = i;
        break;
      } else {
        uf.connect(a, b);
      }
    }
    // 情况1:节点只有环, 移除对应的边
    if (edgeRemoved == -1) {
      return edges[edgeMakesCycle];
    }
    // 情况2: 节点有两个父节点，移除第二个边
    if (edgeMakesCycle == -1) {
      return edges[edgeRemoved];
    }

    // 情况3: 有环，且节点有两个父节点, 移除第一个边
    int u = edges[edgeRemoved][1];
    int v = parent[u];
    vector<int> res{v, u};
    return res;
  }
};
// @lc code=end
