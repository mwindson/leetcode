package Problem701_800;


/**
 * Created by mwindson on 2018/1/23.
 * https://leetcode.com/problems/delete-and-earn/description/
 */
public class Problem740 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }

    // for numbers from [1 - 10000], each has a total sum sums[i]; if you earn sums[i], you cannot earn sums[i-1] and sums[i+1]
    public static int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] value = new int[n];
        for (int num : nums)
            value[num] += num;
        int[] t = new int[n];
        t[0] = value[0];
        t[1] = Math.max(value[0], value[1]);
        for (int i = 2; i < value.length; i++) {
            t[i] = Math.max(t[i - 2] + value[i], t[i - 1]);
        }
        return t[n - 1];
    }
}
