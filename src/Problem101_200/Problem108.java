package Problem101_200;

/**
 * Created by mwindson on 2017/3/9.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/?tab=Description
 */
public class Problem108 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(sortedArrayToBST(nums));
    }


    // balanced BST 左右子树node数必定相差1或相等，且左子树节点小于右子树节点，因此对数组进行分割，从小到大进行构建树
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public static TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

}
