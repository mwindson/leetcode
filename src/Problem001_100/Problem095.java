package Problem001_100;

import Util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/7.
 * https://leetcode.com/problems/unique-binary-search-trees-ii/?tab=Description
 */
public class Problem095 {
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return genTrees(1, n);
    }

    //以i为root时，左子树以1—i-1构成，右子树以i+1—n构成，由此形成递归
    private static List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
