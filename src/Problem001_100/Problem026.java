package Problem001_100;

/**
 * Created by mwindson on 2017/2/3.
 * Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Problem026 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
