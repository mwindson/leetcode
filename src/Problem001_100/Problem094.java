package Problem001_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/3/6.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/?tab=Description
 */
public class Problem094 {
    public static void main(String[] args) {
        String s = "[]";
        TreeNode root = TreeNode.parse(s);
        System.out.println(inorderTraversal(root));
    }

    //    中序遍历稍微复杂，使用一个指针p指向下一个待访问的节点，p初始化为根节点。在每次循环中执行以下操作：
    //    如果p非空，则把p入栈，p变为p的左儿子。
    //    如果p为空，说明已经向左走到尽头了，弹出当前栈顶元素，进行访问，并把p更新为其右儿子。
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return list;
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            list.add(stack.peek().val);
            stack.pop();
            node = node.right;
        }
        return list;
    }
}
