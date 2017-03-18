package Problem101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/3/18.
 * https://leetcode.com/problems/binary-tree-right-side-view/#/description
 */
public class Problem199 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1,2,3,null,4,null,5]");
        System.out.println(rightSideView(tree));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> views = new ArrayList<>();
        if (root == null)
            return views;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int size = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) views.add(node.val);
                if (node.right != null)
                    q.add(node.right);
                if (node.left != null)
                    q.add(node.left);
            }
            size = q.size();
        }
        return views;
    }
}
