package Problem201_300;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by mwindson on 2017/8/25.
 * https://leetcode.com/problems/sliding-window-maximum/description/
 */
public class Problem239 {
    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        int k = 5;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    static class segNode {
        public segNode left;
        public segNode right;
        public int l;
        public int r;
        public int max;

        segNode(int lIndex, int rIndex) {
            l = lIndex;
            r = rIndex;
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        segNode root = build(nums, 0, nums.length - 1);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            result[i] = query(root, i, i + k - 1);
        }
        return result;
    }

    public static segNode build(int[] nums, int l, int r) {
        segNode node = new segNode(l, r);
        if (l == r) {
            node.max = nums[l];
        } else if (l < r) {
            node.left = build(nums, l, (l + r) / 2);
            node.right = build(nums, (l + r) / 2 + 1, r);
            node.max = Math.max(node.left.max, node.right.max);
        }
        return node;
    }

    public static int query(segNode node, int l, int r) {
        if (node.l == l && node.r == r) {
            return node.max;
        } else {
            int leftNum = Integer.MIN_VALUE;
            int rightNum = Integer.MIN_VALUE;
            if (node.left.r >= l) {
                leftNum = query(node.left, l, Math.min(r, node.left.r));
            }
            if (node.right.l <= r) {
                rightNum = query(node.right, Math.max(l, node.right.l), r);
            }
            return Math.max(leftNum, rightNum);
        }
    }
}
