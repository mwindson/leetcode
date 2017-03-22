package Problem201_300;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mwindson on 2017/3/22.
 * https://leetcode.com/problems/binary-tree-paths/#/description
 */
public class Problem257 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,4,5,6]");
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        buildPath(paths, "", root);
        return paths;
    }

    public static void buildPath(List<String> paths, String s, TreeNode node) {
        if (node.left == null && node.right == null) {
            if (Objects.equals(s, ""))
                s = s + node.val;
            else
                s = s + "->" + node.val;
            paths.add(s);
        } else {
            if (Objects.equals(s, ""))
                s = s + node.val;
            else
                s = s + "->" + node.val;
            if (node.left != null)
                buildPath(paths, s, node.left);
            if (node.right != null)
                buildPath(paths, s, node.right);
            s = s.substring(0, s.length() - 1);
        }
    }
}
