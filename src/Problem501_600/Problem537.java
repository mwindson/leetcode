package Problem501_600;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/complex-number-multiplication/#/description
 */
public class Problem537 {
    public static void main(String[] args) {
        String a = "1+-2i";
        String b = "2+-4i";
        System.out.println(complexNumberMultiply(a, b));
    }

    public static String complexNumberMultiply(String a, String b) {
        String[] A = a.split("(\\+|i)");
        int aReal = Integer.valueOf(A[0]);
        int aImaginary = Integer.valueOf(A[1]);
        String[] B = b.split("(\\+|i)");
        int bReal = Integer.valueOf(B[0]);
        int bImaginary = Integer.valueOf(B[1]);
        int resReal = (aReal * bReal) - (aImaginary * bImaginary);
        int resImaginary = (aReal * bImaginary) + (bReal * aImaginary);
        return resReal + "+" + resImaginary + "i";
    }
}
