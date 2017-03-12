package Problem101_200;

/**
 * Created by mwindson on 2017/3/12.
 * https://leetcode.com/problems/single-number-ii/?tab=Description
 */
public class Problem137 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 3};
        System.out.println(singleNumber(nums));
    }

    // 00 -> 01 -> 10 -> 00
    // 1.twos=0,store nums[i] into ones
    //2.num[i]&~nums[i] => twos =0 ,clear twos
    //3.if nums[i] appear second times,then ones=0,two=nums[i]
    //4.the third times,ones=0,twos=0,return to 1
    //so,ones
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
