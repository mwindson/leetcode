package Problem201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/9/20.
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class Problem220 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 2, 4, 8};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
    }

    // Suppose we have consecutive buckets covering the range of nums with each bucket a width of (t+1).
    // If there are two item with difference <= t, one of the two will happen:
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> buckets = new HashMap<>();
        long width = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getId(nums[i], width);
            if (buckets.containsKey(m))
                return true;
            if (buckets.containsKey(m - 1) && Math.abs(nums[i] - buckets.get(m - 1)) < width)
                return true;
            if (buckets.containsKey(m + 1) && Math.abs(nums[i] - buckets.get(m + 1)) < width)
                return true;
            buckets.put(m, (long) nums[i]);
            if (i >= k) buckets.remove(getId(nums[i - k], width));
        }
        return false;
    }

    private static long getId(long i, long width) {
        return i < 0 ? (i + 1) / width - 1 : i / width;
    }
}
