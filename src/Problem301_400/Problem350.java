package Problem301_400;

import java.util.*;

/**
 * Created by mwindson on 2017/5/26.
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/#/description
 */
public class Problem350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 2, 5};
        int[] nums2 = {2, 4, 3,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) > 1)
                    map.put(num, map.get(num) - 1);
                else
                    map.remove(num);
                intersection.add(num);
            }
        }
        int[] res = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            res[i] = intersection.get(i);
        }
        return res;
    }
}
