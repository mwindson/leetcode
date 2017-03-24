package Problem001_100;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/24.
 * https://leetcode.com/problems/permutation-sequence/#/description
 */
public class Problem060 {
    public static void main(String[] args) {
        System.out.println(getPermutation(5, 6));
    }

//    public static String getPermutation(int n, int k) {
//        List<String> res = new ArrayList<>();
//        backTracking("", n, k, res);
//        return res.get(k - 1);
//    }
//
//    private static void backTracking(String s, int n, int k, List<String> res) {
//        if (res.size() < k) {
//            if (s.length() == n) {
//                res.add(s);
//            } else if (s.length() < n) {
//                for (int i = 1; i <= n; i++) {
//                    if (s.contains(String.valueOf(i))) continue;
//                    backTracking(s + i, n, k, res);
//                }
//            }
//        }
//    }

    /**
     * k = k - (index from previous) * (n-1)! = k - 2*(n-1)! = 13 - 2*(3)! = 1
     * for example {1,2,3,4}
     * 1 + (permutations of 2, 3, 4)
     * 2 + (permutations of 1, 3, 4)
     * 3 + (permutations of 1, 2, 4)
     * 4 + (permutations of 1, 2, 3)
     **/
    public static String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }
}
