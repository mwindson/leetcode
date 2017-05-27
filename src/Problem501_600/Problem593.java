package Problem501_600;

/**
 * Created by mwindson on 2017/5/27.
 * https://leetcode.com/problems/valid-square/#/description
 */
public class Problem593 {
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] lengths = {calDistance(p1, p2), calDistance(p2, p3), calDistance(p3, p4),
                calDistance(p4, p1), calDistance(p1, p3), calDistance(p2, p4)}; // all 6 sides

        long max = 0, nonMax = 0;
        for (long len : lengths) {
            max = Math.max(max, len);
        }
        int count = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] == max) count++; // diagonal side
            else nonMax = lengths[i]; // edge side.
        }
        if (count != 2) return false; // diagonals lenghts have to be same.

        for (long len : lengths) {
            if (len != max && len != nonMax) return false; // sides have to be same length
        }
        return true;
    }

    private static int calDistance(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
