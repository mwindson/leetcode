import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/21.
 */
public class Problem004 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {4, 5};
//        The median is 2.0
//        Scanner in = new Scanner(System.in);
        System.out.print(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] num1, int[] num2) {
        double Median = 0.0;
        int size1 = num1.length;
        int size2 = num2.length;
        int count = size1 + size2;
        int i = 0, j = 0;
        int number = 0;

        if (count % 2 == 0) {
            count = count / 2 + 1;
        }

        return Median;
    }
}
