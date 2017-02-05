package Problem001_100;

/**
 * Created by mwindson on 2017/2/5.
 * Question: https://leetcode.com/problems/remove-element/
 */
public class Problem027 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            //  A[i] = the last element in the modifying array
            while (A[i] == elem && i < len) {
                A[i] = A[--len];
            }
        }
        return len;
    }
}
