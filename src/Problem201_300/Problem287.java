package Problem201_300;

/**
 * Created by mwindson on 2017/6/6.
 * https://leetcode.com/problems/find-the-duplicate-number/#/solutions
 */
public class Problem287 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) nums[i]--;
        int slow = n - 1;
        int fast = n - 1;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = n - 1;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow + 1;
    }
}
