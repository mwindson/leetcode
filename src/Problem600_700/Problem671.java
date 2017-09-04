package Problem600_700;

import Util.TreeNode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mwindson on 2017/9/4.
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 */
public class Problem671 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[2,2,5,2,3]");
        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Set<Integer> set = new TreeSet<>();
        dfs(root, set);
        Iterator<Integer> iterator = set.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            int result = iterator.next();
            if (count == 2) {
                return result;
            }
        }
        return -1;
    }

    private static void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
}
