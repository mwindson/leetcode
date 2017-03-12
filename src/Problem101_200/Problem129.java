package Problem101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/12.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/?tab=Description
 */
public class Problem129 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2]");
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        if (root == null)
            return sum;
        findNum(list, root, 0);
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    private static void findNum(List<Integer> list, TreeNode node, int num) {
        if (node.left != null)
            findNum(list, node.left, num * 10 + node.val);
        if (node.right != null)
            findNum(list, node.right, num * 10 + node.val);
        if (node.left == null && node.right == null)
            list.add(num * 10 + node.val);
    }
}
