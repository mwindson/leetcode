package Problem600_700;

/**
 * Created by mwindson on 2017/8/21.
 * https://leetcode.com/problems/remove-9/description/
 */
public class Problem660 {
    public static void main(String[] args) {
        System.out.println(newInteger(80));
    }

    public static int newInteger(int n) {
        if (n == 0) return 0;
        StringBuilder res = new StringBuilder();
        while (n >= 9) {
            res.append(n % 9);
            n /= 9;
        }
        res.append(n);
        return Integer.valueOf(res.reverse().toString());
    }
}
