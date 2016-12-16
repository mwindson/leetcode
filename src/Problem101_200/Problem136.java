package Problem101_200;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Problem136 {
    public static void main(String[] args){
        int[] nums={1,1,2,3,3,4,4,5,5};
        System.out.print(singleNumber(nums));
    }
    // the key to the problem: A XOR A=0
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i<nums.length; i++)
        {
            result ^=nums[i];
        }
        return result;
    }
}
