package Problem501_600;

import java.util.*;

/**
 * Created by mwindson on 2017/5/31.
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class Problem599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "KFC", "Tapioca Express", "Burger King"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> common = new ArrayList<>();
        Map<String, Integer> diff = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            diff.put(list1[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (diff.containsKey(list2[i])) {
                if (diff.get(list2[i]) + i < minIndexSum) {
                    minIndexSum = diff.get(list2[i]) + i;
                    common.clear();
                    common.add(list2[i]);
                } else if (diff.get(list2[i]) + i == minIndexSum) {
                    common.add(list2[i]);
                }
            }
        }
        String[] res = new String[common.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = common.get(i);
        }
        return res;
    }
}
