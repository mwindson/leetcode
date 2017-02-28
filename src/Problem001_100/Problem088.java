package Problem001_100;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mwindson on 2017/2/28.
 * https://leetcode.com/problems/merge-sorted-array/?tab=Description
 */
public class Problem088 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 7, 9, -1, -1, -1, -1, -1};
        int[] nums2 = {2, 3, 4, 6, 8};
        merge(nums1, 4, nums2, 5);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
        //从大到小进行合并
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1)
            nums1[k--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
        while (j > -1)
            nums1[k--] = nums2[j--];
    }
}
