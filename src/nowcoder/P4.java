package nowcoder;

import Util.TreeNode;

public class P4 {
    // todo
    public static void main(String[] args) {
        P4 p = new P4();
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        System.out.println(p.reConstructBinaryTree(pre, in));
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode helper(int[] pre, int pi, int pj, int[] in, int ii, int ij) {
        if (pi > pj || ii > ij) return null;
        TreeNode node = new TreeNode(pre[pi]);
        int i = ii;
        for (i = ii; i <= ij; i++) {
            if (in[i] == pre[pi]) {
                break;
            }
        }
        int j = pi;
        while (j <= pj && (i > 0 && pre[j] != in[i - 1])) {
            j++;
        }
        node.left = helper(pre, pi + 1, j, in, ii, i - 1);
        node.right = helper(pre, j + 1, pj, in, i + 1, ij);
        return node;
    }
}
