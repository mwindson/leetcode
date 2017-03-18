package Problem101_200;

/**
 * Created by mwindson on 2017/3/18.
 * https://leetcode.com/problems/rotate-array/#/solutions
 */
public class Problem189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate(nums, 3);
        System.out.println(nums);
    }

    // 先反转整个数组，然后再分别反转两部分数组
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
