package Problem101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/11.
 * https://leetcode.com/problems/pascals-triangle/?tab=Description
 */
public class Problem118 {
    public static void main(String[] args) {
        System.out.println(generate(15));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> numLists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    list.add(numLists.get(numLists.size() - 1).get(j - 1) + numLists.get(numLists.size() - 1).get(j));
            }
            numLists.add(new ArrayList<>(list));
            list.clear();
        }
        return numLists;
    }
}
