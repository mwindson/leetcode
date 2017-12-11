package Problem701_800;

import Util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/12/11.
 * https://leetcode.com/problems/self-dividing-numbers/description/
 */
public class Problem728 {
    public static void main(String[] args) {
        int left = 1, right = 200;
        System.out.println(selfDividingNumbers(left, right));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) list.add(i);
        }
        return list;
    }
}
