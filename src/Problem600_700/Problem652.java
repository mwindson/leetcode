package Problem600_700;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/8/1.
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 */
public class Problem652 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,4,null,2,4,null,null,4]");
        System.out.println(findDuplicateSubtrees(root));
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicateSubtrees = new ArrayList<>();
        postOrder(root, new HashMap<>(), duplicateSubtrees);
        return duplicateSubtrees;
    }

    public static String postOrder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String seq = cur.val + ',' + postOrder(cur.left, map, res) + ',' + postOrder(cur.right, map, res);
        if (map.getOrDefault(seq, 0) == 1) res.add(cur);
        map.put(seq, map.getOrDefault(seq, 0) + 1);
        return seq;
    }
}
