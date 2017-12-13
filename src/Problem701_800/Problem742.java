package Problem701_800;

import Util.TreeNode;

import java.util.*;

/**
 * Created by mwindson on 2017/12/13.
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/description/
 */
public class Problem742 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,4]");
        System.out.println(findClosestLeaf(root, 1));
    }

    public static int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        convertToGraph(graph, root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        for (TreeNode node : graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                visited.add(node);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                List<TreeNode> list = graph.get(node);
                if (graph.get(node).size() <= 1) return node.val;
                for (TreeNode t : list) {
                    if (!visited.contains(t) && t != null) {
                        visited.add(t);
                        queue.add(t);
                    }
                }
            }
        }
        return -1;
    }

    private static void convertToGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node != null) {
            if (!graph.containsKey(node)) graph.put(node, new ArrayList<>());
            if (!graph.containsKey(parent)) graph.put(parent, new ArrayList<>());
            graph.get(parent).add(node);
            graph.get(node).add(parent);
            convertToGraph(graph, node.left, node);
            convertToGraph(graph, node.right, node);
        }
    }
}
