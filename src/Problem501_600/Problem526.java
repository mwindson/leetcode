package Problem501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/16.
 * https://leetcode.com/problems/beautiful-arrangement/#/description
 */
public class Problem526 {
    public static void main(String[] args) {
        System.out.println(countArrangement(5));
    }

    public static int countArrangement(int N) {
        List<Integer> tmpList = new ArrayList<>();
        int[] count = {0};
        backTracking(1, count, N, new int[N + 1]);
        return count[0];
    }

    private static void backTracking(int pos, int[] count, int n, int[] used) {
        if (pos > n) {
            count[0]++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (used[i] == 0 && (pos % i == 0 || i % pos == 0)) {
                    used[i] = 1;
                    backTracking(pos + 1, count, n, used);
                    used[i] = 0;
                }
            }
        }
    }
}
