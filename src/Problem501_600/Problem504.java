package Problem501_600;

/**
 * Created by mwindson on 2017/5/10.
 * https://leetcode.com/problems/base-7/#/description
 */
public class Problem504 {
    public static void main(String[] args) {
        int num = -100;
        System.out.println(convertToBase7(num));
    }

    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
