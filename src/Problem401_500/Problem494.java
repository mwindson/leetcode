package Problem401_500;

/**
 * Created by mwindson on 2017/3/22.
 * https://leetcode.com/problems/target-sum/#/description
 */
public class Problem494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays(nums, S));
    }
    // too slow
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        return countWays(nums, 0, S);
    }

    private static int countWays(int[] nums, int index, int S) {
        if (index == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return countWays(nums, index + 1, S - nums[index]) + countWays(nums, index + 1, S + nums[index]);
    }


//    // DP
//    public int findTargetSumWays(int[] nums, int s) {
//        int sum = 0;
//        for(int i: nums) sum+=i;
//        if(s>sum || s<-sum) return 0;
//        int[] dp = new int[2*sum+1];
//        dp[0+sum] = 1;
//        for(int i = 0; i<nums.length; i++){
//            int[] next = new int[2*sum+1];
//            for(int k = 0; k<2*sum+1; k++){
//                if(dp[k]!=0){
//                    next[k + nums[i]] += dp[k];
//                    next[k - nums[i]] += dp[k];
//                }
//            }
//            dp = next;
//        }
//        return dp[sum+s];
//    }
}
