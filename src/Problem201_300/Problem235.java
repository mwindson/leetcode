package Problem201_300;

/**
 * Created by mwindson on 2017/6/2.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description
 */
public class Problem235 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = TreeNode.parse("[2,0,null,null,3,5]");
        TreeNode q = TreeNode.parse("[4,3,5]");
        System.out.println(lowestCommonAncestor(root, p, q));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root || (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        } else if (q.val < root.val && p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (q.val > root.val && p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
