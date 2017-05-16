package Problem301_400;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mwindson on 2017/5/16.
 * https://leetcode.com/problems/shuffle-an-array/#/description
 */
public class Problem384 {
    public static class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            if (nums == null) return null;
            int[] a = nums.clone();
            for (int j = 1; j < a.length; j++) {
                int i = random.nextInt(j + 1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        int[] res1 = obj.reset();
        int[] res2 = obj.shuffle();
    }
}
