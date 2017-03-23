package Problem401_500;

/**
 * Created by mwindson on 2017/3/23.
 * https://leetcode.com/problems/total-hamming-distance/#/description
 */
public class Problem477 {
    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }

    /**
     * For all number a1, a2, a3,..., a(n), if there are p numbers have 0 as LSB (put in set M), and q numbers have 1 for LSB (put in set N).
     * The total Hamming distance will get pq from LSB.
     **/
    public static int totalHammingDistance(int[] nums) {
        int n = 31;
        int len = nums.length;
        int[] countOfOnes = new int[n];
        // calculate the LSB counts
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                countOfOnes[j] += (nums[i] >> j) & 1;
            }
        }
        int sum = 0;
        // calculate the total Hamming distance
        for (int count : countOfOnes) {
            sum += count * (len - count);
        }
        return sum;
    }
}
