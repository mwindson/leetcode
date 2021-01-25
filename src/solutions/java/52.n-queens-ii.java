package solutions.java;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 * @tag backtracking
 */

// @lc code=start
class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] vertical = new boolean[n];
        boolean[] leftfall = new boolean[2 * n - 1];
        boolean[] rightfall = new boolean[2 * n - 1];
        backtrack(n, vertical, leftfall, rightfall, 0);
        return count;
    }

    public void backtrack(int n, boolean[] v, boolean[] l, boolean[] r, int row) {
        for (int col = 0; col < n; col++) {
            if (v[col] || l[row - col + n - 1] || r[row + col])
                continue;
            if (row == n - 1) {
                count++;
            } else {
                v[col] = true;
                l[row - col + n - 1] = true;
                r[row + col] = true;
                backtrack(n, v, l, r, row + 1);
                v[col] = false;
                l[row - col + n - 1] = false;
                r[row + col] = false;
            }
        }
    }
}
// @lc code=end
