package Problem201_300;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mwindson on 2017/1/28.
 * Question: https://leetcode.com/problems/missing-number/
 */
public class Problem268 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 3};
        System.out.println(missingNumber(nums));
    }

    // a^b^b=a => (1^2^3,...,n)^(n-1^n-2...1)=n
    public static int missingNumber(int[] nums) {
//        -----------sum-----------------
//        int len = nums.length;
//        int sum = (0+len)*(len+1)/2;
//        for(int i=0; i<len; i++)
//            sum-=nums[i];
//---------binary search---------------
//        Arrays.sort(nums);
//        int left = 0, right = nums.length, mid= (left + right)/2;
//        while(left<right){
//            mid = (left + right)/2;
//            if(nums[mid]>mid) right = mid;
//            else left = mid+1;
//        }
//        return left;

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
