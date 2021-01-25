package solutions.java;

import java.util.*;
/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    // @tag 滑动窗口
    // 在一个滑动窗口只包含两个不同的整数，求最大的窗口大小
    public int totalFruit(int[] tree) {
        int maxAmount = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> fruits = new HashMap<>();
        while (right < tree.length) {
            fruits.put(tree[right], fruits.getOrDefault(tree[right], 0) + 1);
            while (fruits.size() > 2) {
                int val = fruits.getOrDefault(tree[left], 0);
                if (val <= 1) {
                    fruits.remove(tree[left]);
                } else {
                    fruits.put(tree[left], val - 1);
                }
                left++;
            }
            maxAmount = Math.max(maxAmount, right - left + 1);
            right++;
        }
        return maxAmount;
    }
}
// @lc code=end
