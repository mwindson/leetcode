import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Problem344 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s) {
        StringBuilder result = new StringBuilder(s);
        return result.reverse().toString();
    }
}
