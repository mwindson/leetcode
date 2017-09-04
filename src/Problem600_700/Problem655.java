package Problem600_700;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/9/1.
 * https://leetcode.com/problems/print-binary-tree/description/
 */
public class Problem655 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,null,4,5]");
        System.out.println(printTree(root));
    }

    public static List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, cols = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < cols; i++) row.add("");
        for (int i = 0; i < rows; i++) res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, cols - 1);
        return res;
    }

    private static void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) return;
        res.get(row).set((i + j) / 2, Integer.toString(root.val));
        populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
        populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
