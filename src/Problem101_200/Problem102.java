package Problem101_200;

import java.util.*;
import java.util.logging.Level;

import Util.*;

/**
 * Created by mwindson on 2017/3/8.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/?tab=Description
 */
public class Problem102 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[3,9,20,null,null,15,7]");
        System.out.println(levelOrder(tree));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> qNode = new ArrayDeque<>();
        Queue<Integer> qLevel = new ArrayDeque<>();
        int level = 0;
        int prevlevel = -1;
        qNode.add(root);
        qLevel.add(level);
        List<Integer> tmp = new ArrayList<>();
        while (!qNode.isEmpty() && !qLevel.isEmpty()) {
            TreeNode node = qNode.peek();
            level = qLevel.peek();
            if (level > prevlevel) {
                if (prevlevel != -1) {
                    list.add(new ArrayList<Integer>(tmp));
                }
                tmp.clear();
                tmp.add(node.val);
            } else {
                tmp.add(node.val);
            }
            prevlevel = level;
            if (node.left != null) {
                qNode.add(node.left);
                qLevel.add(level + 1);
            }
            if (node.right != null) {
                qNode.add(node.right);
                qLevel.add(level + 1);
            }
            qNode.remove();
            qLevel.remove();
        }
        if (!tmp.isEmpty()) list.add(new ArrayList<>(tmp));
        return list;
    }


//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
//
//        if(root == null) return wrapList;
//
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int levelNum = queue.size();
//            List<Integer> subList = new LinkedList<Integer>();
//            for(int i=0; i<levelNum; i++) {
//                if(queue.peek().left != null) queue.offer(queue.peek().left);
//                if(queue.peek().right != null) queue.offer(queue.peek().right);
//                subList.add(queue.poll().val);
//            }
//            wrapList.add(subList);
//        }
//        return wrapList;
//    }
}
