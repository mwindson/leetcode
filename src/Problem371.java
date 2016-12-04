import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/4.
 */
// todo 待完成
public class Problem371 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(getSum(a, b));
    }

    public static int getSum(int a, int b) {
        boolean carry=false;
        int sum = 0;
        String numA = Integer.toBinaryString(a);
        String numB = Integer.toBinaryString(b);
        if ((numA.length() == numB.length()) && (numA.charAt(0) == '1' && numB.charAt(0) == '1')) {
            sum = (a ^ b) +(int) Math.pow(2, numA.length());
        } else {
            sum = a ^ b;
        }
        return sum;
    }
}
