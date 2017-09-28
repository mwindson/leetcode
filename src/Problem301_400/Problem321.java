package Problem301_400;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/9/26.
 * https://leetcode.com/problems/create-maximum-number/description/
 */
public class Problem321 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {8, 7, 4};
        int k = 3;
        System.out.println(Arrays.toString(maxNumber(nums1, nums2, k)));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= len1; i++) {
            int[] subArray1 = maxSubarray(nums1, i);
            int[] subArray2 = maxSubarray(nums2, k - i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;
            while (subArray1.length > 0 && subArray2.length > 0 && pos1 < subArray1.length && pos2 < subArray2.length) {
                if (compare(subArray1, pos1, subArray2, pos2)) {
                    res[tpos++] = subArray1[pos1++];
                } else {
                    res[tpos++] = subArray2[pos2++];
                }
            }
            while (pos1 < subArray1.length)
                res[tpos++] = subArray1[pos1++];
            while (pos2 < subArray2.length)
                res[tpos++] = subArray2[pos2++];
            if (!compare(ans, 0, res, 0))
                ans = res;
        }
        return ans;
    }

    private static boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] < nums2[start2]) return false;
            if (nums1[start1] > nums2[start2]) return true;
        }
        return start1 != nums1.length;
    }

    private static int[] maxSubarray(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (index > 0 && index + nums.length - i > k && res[index - 1] < nums[i]) {
                index--;
            }
            if (index < k)
                res[index++] = nums[i];
        }
        return res;
    }
}
