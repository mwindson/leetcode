package Problem401_500;

/**
 * Created by mwindson on 2017/6/9.
 * https://leetcode.com/problems/arithmetic-slices/#/description
 */
public class Problem413 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 4, 5};
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
