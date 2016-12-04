import javax.swing.tree.TreeNode;

/**
 * Created by Administrator on 2016/12/4.
 */
// todo 待完成 
public class Problem104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        int maxdepth = 0;
        if (root == null) return 0;
        TreeNode node = root;
        countDepth(root, 0, maxdepth);

        return maxdepth;
    }

    public void countDepth(TreeNode node, int depth, int maxdepth) {
        if (node.left != null) {
            depth++;
            countDepth(node.left, depth, maxdepth);
        } else if (node.right != null) {
            depth++;
            countDepth(node.right, depth, maxdepth);
        } else {
            maxdepth = Math.max(maxdepth, depth);
        }
    }
    
}
