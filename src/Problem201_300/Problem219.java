package Problem201_300;

import java.util.HashMap;

/**
 * Created by mwindson on 2017/3/17.
 * https://leetcode.com/problems/contains-duplicate-ii/#/description
 */
public class Problem219 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k)
                    return true;
                else
                    map.replace(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
