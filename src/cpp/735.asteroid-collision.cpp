/*
 * @lc app=leetcode id=735 lang=cpp
 *
 * [735] Asteroid Collision
 *
 * https://leetcode.com/problems/asteroid-collision/description/
 *
 * algorithms
 * Medium (44.33%)
 * Likes:    3577
 * Dislikes: 288
 * Total Accepted:    203.1K
 * Total Submissions: 458.2K
 * Testcase Example:  '[5,10,-5]'
 *
 * We are given an array asteroids of integers representing asteroids in a
 * row.
 *
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 *
 *
 * Example 1:
 *
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never
 * collide.
 *
 *
 * Example 2:
 *
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 *
 *
 * Example 3:
 *
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide
 * resulting in 10.
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> asteroidCollision(vector<int> &asteroids) {
    stack<int> s;
    for (int asteroid : asteroids) {
      bool exploded = false;
      while (!s.empty() && ((s.top() > 0 && asteroid < 0))) {
        if (s.top() + asteroid < 0) {
          s.pop();
        } else if (s.top() + asteroid == 0) {
          s.pop();
          exploded = true;
          break;
        } else {
          exploded = true;
          break;
        }
      }
      if (!exploded) {
        s.push(asteroid);
      }
    }
    vector<int> res;
    while (!s.empty()) {
      res.insert(res.begin(), s.top());
      s.pop();
    }
    return res;
  }
};
// @lc code=end
