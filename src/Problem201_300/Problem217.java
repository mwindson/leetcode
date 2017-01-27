package Problem201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mwindson on 2017/1/27.
 * Question: https://leetcode.com/problems/contains-duplicate/
 */
public class Problem217 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums)
            if (!set.add(i))
                return true;
        return false;
    }
}
