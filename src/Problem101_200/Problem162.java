package Problem101_200;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/find-peak-element/#/description
 */
public class Problem162 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    index = i;
                    break;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    index = i;
                    break;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
