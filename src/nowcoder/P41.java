package nowcoder;

import java.util.ArrayList;

public class P41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int k = 2; k < 2 * sum; k++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (2 * sum % k == 0) {
                int tmp = 2 * sum / k - (k - 1);
                if (tmp > 0 && tmp % 2 == 0) {
                    int a = tmp / 2;
                    for (int i = a; i < a + k; i++) list.add(i);
                    res.add(0, list);
                }
            }
        }
        return res;
    }
}
