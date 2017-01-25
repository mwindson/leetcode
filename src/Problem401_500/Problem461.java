package Problem401_500;

/**
 * Created by mwindson on 2017/1/25.
 */
public class Problem461 {
    public static void main(String[] args) {
        int x = 4, y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int diff_num = 0;
        int result = x ^ y;
        while (result > 0) {
            if (result % 2 == 1) {
                diff_num++;
            }
            result /= 2;
        }
        return diff_num;
//      best: return Integer.bitCount(x ^ y);
    }
}
