package Problem401_500;

/**
 * Created by mwindson on 2017/3/20.
 * https://leetcode.com/problems/arranging-coins/#/description
 */
public class Problem441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        int k = 0;
        int rest = n;
        while (rest >= k) {
            rest -= k;
            k++;
        }

        return k-1;
    }
}
