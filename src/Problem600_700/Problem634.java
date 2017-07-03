package Problem600_700;

/**
 * Created by mwindson on 2017/7/3.
 * https://leetcode.com/problems/find-the-derangement-of-an-array/#/description
 */
public class Problem634 {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.println(findDerangement(i));
        }
    }

    // 当k排在第n位时，除了n和k以外还有n-2个数，其错排数为Dn-2。
    // 当k不排在第n位时，那么将第n位重新考虑成一个新的“第k位”，这时的包括k在内的剩下n-1个数的每一种错排，
    // 都等价于只有n-1个数时的错排（只是其中的第k位会换成第n位）。其错排数为Dn-1。
    public static int findDerangement(int n) {
        int mod = 1000000007;
        long dn2 = 0, dn1 = 1;
        long res = n == 1 ? 0 : 1;
        for (int i = 3; i <= n; i++) {
            res = (i - 1) * (dn1 + dn2) % mod;
            dn2 = dn1;
            dn1 = res;
        }
        return (int) res;
    }
}
