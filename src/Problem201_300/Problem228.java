package Problem201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/4/6.
 * https://leetcode.com/problems/summary-ranges/#/description
 */
public class Problem228 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();
        if (nums.length == 0)
            return range;
        Arrays.sort(nums);
        int start = nums[0];
        int length = 0;
        int i = 1;
        while (i < nums.length - length) {
            if (nums[length + i] - start != i) {
                if (i == 1) {
                    range.add("" + start);
                } else {
                    range.add("" + start + "->" + nums[length + i - 1]);
                }
                start = nums[length + i];
                length = length + i;
                i = 0;
            }
            i++;
        }
        if (nums[length + i - 1] == start) {
            range.add("" + start);
        } else {
            range.add("" + start + "->" + nums[length + i - 1]);
        }
        return range;
    }
}
