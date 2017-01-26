package Problem001_100;

/**
 * Created by mwindson on 2017/1/26.
 */
public class Problem100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null & q == null)) {
            return false;
        }
        if (p.val == q.val) {
            if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
