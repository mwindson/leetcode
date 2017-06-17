package Problem001_100;

/**
 * Created by mwindson on 2017/6/15.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/#/description
 */
public class Problem004 {
    public static void main(String[] args) {
        int[] A = {1, 3}, B = {2, 4};
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n > m) return findMedianSortedArrays(B, A);

        int k = (n + m - 1) / 2;
        int left = 0, right = Math.min(k, n);
        while (left < right) {
            int midA = (left + right) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB])
                left = midA + 1;
            else
                right = midA;
        }
        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(left > 0 ? A[left - 1] : Integer.MIN_VALUE, k - left >= 0 ? B[k - left] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(left < n ? A[left] : Integer.MAX_VALUE, k - left + 1 < m ? B[k - left + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}
