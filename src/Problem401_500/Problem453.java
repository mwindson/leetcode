package Problem401_500;

import java.util.Arrays;

/**
 * Created by mwindson on 2016/12/5.
 */
public class Problem453 {
    public static void main(String[] args) {
        int[] nums = {1, 3,15,6,11};
        System.out.print(minMoves(nums));
    }

    public static int minMoves(int[] nums) {
//        Arrays.sort(nums);
//        int move = 0;
//        int n = nums.length;
//        for (int i = nums.length - 1; i > 0; i--) {
//            move += (nums[i] - nums[i - 1]) * (nums.length - i);
//        }
//        return move;
        int min = nums[0];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                moves += (min - nums[i]) * i;
                min = nums[i];
            }
            else {
                moves += nums[i] - min;
            }
        }

        return moves;
    }
}
