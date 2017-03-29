package Problem201_300;

/**
 * Created by mwindson on 2017/3/29.
 * https://leetcode.com/problems/product-of-array-except-self/#/description
 */
public class Problem238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(productExceptSelf(nums));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // res:1,1,1*2,2*3,2*3*4
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        // right: 2*3*4*5,3*4*5,4*5,5,1
        // res: 2*3*4*5,3*4*5,2*4*5,2*3*5,2*3*4
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
