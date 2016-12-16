package Problem201_300;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Problem292 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(canWinNim(n));
    }

    public static boolean canWinNim(int n) {
        if (n % 4 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
