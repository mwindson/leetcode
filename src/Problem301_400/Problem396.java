package Problem301_400;

/**
 * Created by mwindson on 2017/6/5.
 * https://leetcode.com/problems/rotate-function/#/description
 */
public class Problem396 {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(A));
    }

    // F(k) = F(k-1) + sum - nBk[0]
    public static int maxRotateFunction(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }
}
