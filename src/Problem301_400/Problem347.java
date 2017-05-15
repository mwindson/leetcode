package Problem301_400;

import java.util.*;

/**
 * Created by mwindson on 2017/5/15.
 * https://leetcode.com/problems/top-k-frequent-elements/#/description
 */
public class Problem347 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 3));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
