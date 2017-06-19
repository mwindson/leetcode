package Problem600_700;

import Util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mwindson on 2017/6/19.
 * https://leetcode.com/problems/maximum-distance-in-arrays/#/description
 */
public class Problem624 {
    public static void main(String[] args) {
        Integer[][] arrays = {{1, 2, 3}, {4, 5}, {1, 2, 3}};
        List<List<Integer>> list = new ArrayList<>(arrays.length);
        for (int i = 0; i < arrays.length; i++)
            list.add(Arrays.asList(arrays[i]));
        System.out.println(maxDistance(list));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }

        return result;
    }
}
