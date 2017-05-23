package Problem501_600;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/5/23.
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/#/description
 */
public class Problem581 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

//    public static int findUnsortedSubarray(int[] nums) {
//        int[] sortedNums = nums.clone();
//        Arrays.sort(sortedNums);
//        int start = -1;
//        int end = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != sortedNums[i]) {
//                if (start == -1) {
//                    start = i;
//                    end = i;
//                } else {
//                    end = i;
//                }
//            }
//        }
//        return start == end ? 0 : end - start + 1;
//    }

    public static int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);
            if (A[i] < max) end = i;
            if (A[n - 1 - i] > min) beg = n - 1 - i;
        }
        return end - beg + 1;
    }
}
