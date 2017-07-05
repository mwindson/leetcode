package Problem201_300;

import Util.ListNode;

import java.util.*;

/**
 * Created by mwindson on 2017/7/5.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/#/description
 */
public class Problem297 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            Queue<TreeNode> q = new ArrayDeque<>();
            List<String> list = new ArrayList<>();
            q.add(root);
            list.add(String.valueOf(root.val));
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    list.add(String.valueOf(node.left.val));
                } else {
                    list.add("null");
                }
                if (node.right != null) {
                    q.add(node.right);
                    list.add(String.valueOf(node.right.val));
                } else {
                    list.add("null");
                }
            }
            while (list.get(list.size() - 1) == "null") {
                list.remove(list.size() - 1);
            }
            return "[" + String.join(",", list) + "]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (Objects.equals(data, "[]")) return null;
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            TreeNode currParent = q.poll();
            boolean isLeft = true;
            for (int i = 1; i < vals.length; i++) {
                if (isLeft) {
                    if (!vals[i].equals("null")) {
                        currParent.left = new TreeNode(Integer.valueOf(vals[i]));
                        q.add(currParent.left);
                    }
                } else {
                    if (!vals[i].equals("null")) {
                        currParent.right = new TreeNode(Integer.valueOf(vals[i]));
                        q.add(currParent.right);
                    }
                    currParent = q.poll();
                }
                isLeft = !isLeft;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        Codec codec = new Codec();
        TreeNode root = TreeNode.parse("[1,2,3,null,null,4,null,null,5]");
//        System.out.println(codec.serialize(root));
        TreeNode node = codec.deserialize(codec.serialize(root));
    }
}
