package Problem501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/5/24.
 * https://leetcode.com/problems/binary-tree-tilt/#/description
 */
public class Problem563 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,4,7,9,6]");
        System.out.println(findTilt(root));
    }

    public static int findTilt(TreeNode root) {
        List<Integer> tilts = new ArrayList<>();
        calTilt(root, tilts);
        int sum = 0;
        for (int tilt : tilts) {
            sum += tilt;
        }
        return sum;
    }

    private static int calTilt(TreeNode node, List<Integer> list) {
        if (node == null) return 0;
        int left = calTilt(node.left, list);
        int right = calTilt(node.right, list);
        int tilt = Math.abs(left - right);
        list.add(tilt);
        return left + right + node.val;
    }
}
