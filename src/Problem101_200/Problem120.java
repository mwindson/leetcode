package Problem101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/3/13.
 * https://leetcode.com/problems/triangle/#/description
 */
public class Problem120 {
    public static void main(String[] args) {
        int[][] nums = {{1}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                list.add(nums[i][j]);
            }
            triangle.add(new ArrayList<>(list));
            list.clear();
        }
        System.out.println(minimumTotal(triangle));
    }

    // 搜索每一层的list数字组后，记录对应的数字和
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size()];
        sum[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j == 0)
                    sum[j] = sum[j] + triangle.get(i).get(j);
                else if (j == triangle.get(i).size() - 1)
                    sum[j] = sum[j - 1] + triangle.get(i).get(j);
                else
                    sum[j] = Math.min(sum[j - 1] + triangle.get(i).get(j), sum[j] + triangle.get(i).get(j));
            }
        }
        Arrays.sort(sum);
        return sum[0];
    }
}
