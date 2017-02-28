package Problem001_100;

/**
 * Created by mwindson on 2017/2/25.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?tab=Description
 */
public class Problem080 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
