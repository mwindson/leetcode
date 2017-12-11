package Problem701_800;

/**
 * Created by mwindson on 2017/12/11.
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class Problem724 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int num : nums) sum += num;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }

        return -1;
    }
}
