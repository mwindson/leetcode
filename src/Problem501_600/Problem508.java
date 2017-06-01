package Problem501_600;

import java.util.*;

/**
 * Created by mwindson on 2017/6/1.
 * https://leetcode.com/problems/most-frequent-subtree-sum/#/description
 */
public class Problem508 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[5,2,-5,1,2,3]");
        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
    }

    static int maxFreq = 0;
    static Map<Integer, Integer> freqSum = new HashMap<>();

    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        calSum(root);
        for (int i : freqSum.keySet()) {
            if (freqSum.get(i) == maxFreq) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static int calSum(TreeNode node) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.left != null)
            left = calSum(node.left);
        if (node.right != null)
            right = calSum(node.right);
        int sum = left + right + node.val;
        int freq = freqSum.getOrDefault(sum, 0) + 1;
        freqSum.put(sum, freq);
        maxFreq = Math.max(maxFreq, freq);
        return sum;
    }
}
