package Problem301_400;

/**
 * Created by mwindson on 2017/5/12.
 * https://leetcode.com/problems/increasing-triplet-subsequence/#/description
 */
public class Problem334 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 2, 4, 7, 6};
        System.out.println(increasingTriplet(nums));
    }

    /**
     * The main idea is keep two values when check all elements in the array:
     * the minimum value min until now and the second minimum value secondMin from the minimum value's position until now.
     */
    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < secondMin) secondMin = num;
            else if (num > secondMin) return true;
        }
        return false;
    }
}
