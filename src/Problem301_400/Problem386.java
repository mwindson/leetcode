package Problem301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/4/10.
 * https://leetcode.com/problems/lexicographical-numbers/#/description
 */
public class Problem386 {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(111));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        backTracking(res, 0, 1, n);
        return res;
    }

    public static void backTracking(List<Integer> res, int tmp, int start, int max) {
        for (int i = start; i <= 9; i++) {
            tmp = tmp * 10 + i;
            if (tmp <= max) {
                res.add(tmp);
                backTracking(res, tmp, 0, max);
            } else {
                break;
            }
            tmp = tmp / 10;
        }
    }
//    another solution
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> list = new ArrayList<>(n);
//        int curr = 1;
//        for (int i = 1; i <= n; i++) {
//            list.add(curr);
//            if (curr * 10 <= n) {
//                curr *= 10;
//            } else if (curr % 10 != 9 && curr + 1 <= n) {
//                curr++;
//            } else {
//                while ((curr / 10) % 10 == 9) {
//                    curr /= 10;
//                }
//                curr = curr / 10 + 1;
//            }
//        }
//        return list;
//    }
}
