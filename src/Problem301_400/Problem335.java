package Problem301_400;

/**
 * Created by mwindson on 2017/9/26.
 * https://leetcode.com/problems/self-crossing/description/
 */
public class Problem335 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 3, 3};
        System.out.println(isSelfCrossing(x));
    }

    // Categorize the self-crossing scenarios, there are 3 of them:
    // 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
    // 2. Fifth line meets first line and works for the lines after
    // 3. Sixth line crosses first line and works for the lines after
    public static boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if (len <= 3) return false;
        for (int i = 3; i < len; i++) {
            // Fourth line crosses first line
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            if (i >= 4) {
                // Fifth line meets first line
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
            }
            if (i >= 5) {
                // Sixth line crosses first line and onward
                if (x[i - 2] - x[i - 4] >= 0 && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3])
                    return true;
            }
        }
        return false;
    }
}
