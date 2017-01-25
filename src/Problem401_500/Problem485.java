package Problem401_500;

/**
 * Created by mwindson on 2017/1/25.
 */
public class Problem485 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,0,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int MaxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > MaxCount) {
                MaxCount = count;
            }
        }
        return MaxCount;
    }
}
