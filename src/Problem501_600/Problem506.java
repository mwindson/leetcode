package Problem501_600;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/3/20.
 * https://leetcode.com/problems/relative-ranks/#/description
 */
public class Problem506 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(findRelativeRanks(nums));
    }

    public static String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        // 根据nums数组得分对index数组进行排序
        Arrays.sort(index, (a, b) -> (nums[a] - nums[b]));

        String[] result = new String[nums.length];

        // 替换前三名文字
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
}
