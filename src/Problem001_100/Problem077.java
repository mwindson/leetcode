package Problem001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/2/25.
 * https://leetcode.com/problems/combinations/?tab=Description
 */
public class Problem077 {
    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinitions = new ArrayList<>();
        List<Integer> combinition = new ArrayList<>();
        backTrack(k, 0, n, combinition, combinitions);
        return combinitions;
    }

    public static void backTrack(int length, int first, int max, List<Integer> combinition, List<List<Integer>> combinitions) {
        if (length == 0) {
            combinitions.add(new ArrayList<>(combinition));
        } else {
            for (int i = first + 1; i <= max; i++) {
                combinition.add(i);
                backTrack(length - 1, i, max, combinition, combinitions);
                combinition.remove(combinition.size() - 1);
            }
        }
    }
}
