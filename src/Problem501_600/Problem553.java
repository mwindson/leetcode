package Problem501_600;

/**
 * Created by mwindson on 2017/5/25.
 * https://leetcode.com/problems/optimal-division/#/description
 */
public class Problem553 {
    public static void main(String[] args) {
        int[] nums = {1000, 100, 10, 2};
        System.out.println(optimalDivision(nums));
    }

    // X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses.
    // no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator.
    // Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn.
    // So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
    public static String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }

        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
}
