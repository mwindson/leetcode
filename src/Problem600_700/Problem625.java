package Problem600_700;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mwindson on 2017/6/20.
 * https://leetcode.com/problems/minimum-factorization/#/description
 */
public class Problem625 {
    public static void main(String[] args) {
        System.out.println(smallestFactorization(49));
    }

    public static int smallestFactorization(int a) {
        // Case 1: If number is smaller than 10
        if (a < 10) return a;

        // Case 2: Start with 9 and try every possible digit
        List<Integer> res = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            // If current digit divides n, then store all
            // occurrences of current digit in res
            while (a % i == 0) {
                a = a / i;
                res.add(i);
            }
        }

        // If n could not be broken in form of digits
        if (a != 1) return 0;

        // Get the result from the array in reverse order
        long result = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            result = result * 10 + res.get(i);
            if (result > Integer.MAX_VALUE) return 0;
        }

        return (int) result;
    }
}
