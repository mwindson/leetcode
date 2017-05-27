package Problem501_600;

import java.util.*;

/**
 * Created by mwindson on 2017/5/27.
 * https://leetcode.com/problems/distribute-candies/#/description
 */
public class Problem575 {
    public static void main(String[] args) {
        int[] candies = {1, 1, 1, 3, 3, 3};
        System.out.println(distributeCandies(candies));
    }

    public static int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }
}
