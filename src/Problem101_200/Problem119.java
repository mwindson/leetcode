package Problem101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/11.
 * https://leetcode.com/problems/pascals-triangle-ii/?tab=Description
 */
public class Problem119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        List<Integer> prevlist = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    list.add(prevlist.get(j - 1) + prevlist.get(j));
            }
            prevlist = new ArrayList<>(list);
            list.clear();
        }
        return prevlist;
    }
}
