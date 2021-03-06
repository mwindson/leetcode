package Problem201_300;

/**
 * Created by mwindson on 2017/4/9.
 * https://leetcode.com/problems/single-number-iii/#/description
 */
public class Problem260 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 1, 5};
        System.out.println(singleNumber(nums));
    }

    public static int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            } else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
