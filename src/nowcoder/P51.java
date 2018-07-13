package nowcoder;

public class P51 {
    public int[] multiply(int[] A) {
        int[] leftProduct = new int[A.length];
        int[] rightProduct = new int[A.length];
        leftProduct[0] = 1;
        rightProduct[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * A[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * A[i + 1];
        }
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = leftProduct[i] * rightProduct[i];
        }
        return B;
    }
}
