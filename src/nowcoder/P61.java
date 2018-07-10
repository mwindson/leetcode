package nowcoder;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P61 {
    String Serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                list.add(String.valueOf(node.val));
            } else {
                list.add("#");
            }
        }
        while (list.get(list.size() - 1) == "#") {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.length() == 0) return null;
        String[] strs = str.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root;
        if (strs.length == 0 || strs[0] == "#") {
            root = null;
        } else {
            root = new TreeNode(Integer.valueOf(strs[0]));
        }
        queue.add(root);
        int i = 1;
        while (i < strs.length) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            node.left = getNode(strs[i]);
            i++;
            if (i == strs.length) break;
            node.right = getNode(strs[i]);
            i++;
            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }

    TreeNode getNode(String s) {
        return s.equals("#") ? null : new TreeNode(Integer.valueOf(s));
    }

    public static void main(String[] args) {
        P61 p = new P61();
        TreeNode root = p.Deserialize("5 4 # 3 # 2");
        System.out.println(p.Serialize(root));
    }
}
