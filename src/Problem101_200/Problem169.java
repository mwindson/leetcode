package Problem101_200;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Problem169 {
    public static void main(String[] args){
        int[] nums={1};
        System.out.print(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
        }
        return major;
    }
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        return nums[len/2];
//    }
}
