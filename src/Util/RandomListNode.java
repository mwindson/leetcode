package Util;

/**
 * Created by mwindson on 2017/3/12.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        label = x;
    }

    public static RandomListNode parse(int[] nums) {
        RandomListNode root = new RandomListNode(nums[0]);
        RandomListNode currentNode = root;
        for (int i = 1; i < nums.length; i++) {
            RandomListNode node = new RandomListNode(nums[i]);
            currentNode.next = node;
            currentNode = node;
        }
        return root;
    }
}
