package Problem101_200;

/**
 * Created by mwindson on 2017/3/15.
 * https://leetcode.com/problems/factorial-trailing-zeroes/#/description
 */
public class Problem172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }

    // 只需判断5倍数的个数和2倍数个数，而2倍数个数远多于5倍数的个数，只需判断5倍数的个数
    // 5的倍数产生1个0,25的倍数产生2个0，依次类推
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
