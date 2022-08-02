/*
 * @lc app=leetcode id=621 lang=cpp
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (54.66%)
 * Likes:    6889
 * Dislikes: 1359
 * Total Accepted:    359.9K
 * Total Submissions: 653.1K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any
 * order. Each task is done in one unit of time. For each unit of time, the CPU
 * could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown
 * period between two same tasks (the same letter in the array), that is that
 * there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish
 * all the given tasks.
 *
 *
 * Example 1:
 *
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 *
 *
 * Example 2:
 *
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 *
 *
 * Example 3:
 *
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle
 * -> idle -> A
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= task.length <= 10^4
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 *
 *
 */

// @lc code=start
class Solution {
public:
  int leastInterval(vector<char> &tasks, int n) {
    unordered_map<char, int> map;
    int max_cnt = 0;
    // 找到频次最高的字符
    for (char c : tasks) {
      map[c]++;
      max_cnt = max(max_cnt, map[c]);
    }
    // 计算放置元素的总CPU时间：每个周期内有N+1个放置位，共M-1次
    // A ? ? A ? ? A => (3-1) * (2+1)
    int ans = (max_cnt - 1) * (n + 1);
    for (auto it : map) {
        // 有多个最大频次的，需要在后面增加
      if (it.second == max_cnt) {
        ans++;
      }
    }
    return max<int>(tasks.size(), ans); // 
  }
};
// @lc code=end
