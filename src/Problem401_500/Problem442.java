package Problem401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/3/23.
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description
 */
public class Problem442 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
//        List<Integer> duplicates = new ArrayList<>();
//        if (nums.length == 0)
//            return duplicates;
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1])
//                if (!duplicates.contains(nums[i]))
//                    duplicates.add(nums[i]);
//        }
//        return duplicates;\

        // when find a number i, flip the number at position i-1 to negative.
        // if the number at position i-1 is already negative, i is the number that occurs twice.
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
