package Problem401_500;

import Problem001_100.Problem100;
import Util.*;
/**
 * Created by mwindson on 2016/12/5.
 */

/**
 * Definition for a binary tree node.
 * public class Util.TreeNode {
 * int val;
 * Util.TreeNode left;
 * Util.TreeNode right;
 * Util.TreeNode(int x) { val = x; }
 * }
 */
public class Problem404 {

    public static void main(String[] args) {
        String tree = "[3,9,20,null,null,15,7]";
        System.out.println(sumOfLeftLeaves(TreeNode.parse(tree)));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
