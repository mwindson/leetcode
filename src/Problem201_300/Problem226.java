package Problem201_300;

import Util.*;

/**
 * Created by mwindson on 2017/1/26.
 */
public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp;
        tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
