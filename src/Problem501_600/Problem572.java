package Problem501_600;

/**
 * Created by mwindson on 2017/5/27.
 */
public class Problem572 {
    public static void main(String[] args) {
        TreeNode s = TreeNode.parse("[3,4,5,1,2,null,null,null,null,2]");
        TreeNode t = TreeNode.parse("[4,1,2]");
        System.out.println(isSubtree(s, t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
