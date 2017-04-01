package Problem301_400;

import Util.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by mwindson on 2017/4/1.
 * https://leetcode.com/problems/random-pick-index/#/description
 */
public class Problem398 {
    int[] nums;
    Random rnd;

    public Problem398(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }


    //    2 : It's probability of selection is 1 * (1/2) * (2/3) = 1/3
//    3 : It's probability of selection is (1/2) * (2/3) = 1/3
//    4 : It's probability of selection is just 1/3
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }

    public static void main(String[] args) {
        Problem398 obj = new Problem398(new int[]{1});
        int param_1 = obj.pick(1);
        System.out.println(param_1);
    }
}
