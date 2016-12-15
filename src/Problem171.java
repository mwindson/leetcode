import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Problem171 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.print(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + s.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
