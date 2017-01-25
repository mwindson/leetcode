package Problem401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/1/25.
 */
public class Problem448 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            result.add(i + 1);
//        }
//        for (int j = 0; j < nums.length; j++) {
//            if (result.contains(nums[j])) {
//                result.remove((Integer) nums[j]);
//            }
//        }
//        return result;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 试图为每个数值加n
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            //找出未加n的位置的数值
            if (nums[i] <= n) result.add(i + 1);
        }
        return result;
    }
}
