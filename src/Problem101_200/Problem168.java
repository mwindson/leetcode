package Problem101_200;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Problem168 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(convertToTitle(num));
    }

    public static String convertToTitle(int n) {
        String title = "";
        while (n / 26 != 0) {
            if (n % 26 == 0) {
                title = 'Z' + title;
                n = n / 26 - 1;
            } else {
                title = (char) (n % 26 - 1 + 'A') + title;
                n = n / 26;
            }
        }
        if(n>0) {
            title = (char) (n - 1 + 'A') + title;
        }
        return title;
    }
}
