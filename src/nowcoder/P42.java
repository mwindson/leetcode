package nowcoder;

import java.util.ArrayList;

public class P42 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 16};
        int sum = 17;
        System.out.println(new P42().FindNumbersWithSum(array, sum));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            int target = sum - array[i];
            int left = i + 1, right = array.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (array[mid] == target) {
                    res.add(array[i]);
                    res.add(array[mid]);
                    return res;
                } else if (array[mid] > target) {
                    right = mid - 1;
                } else if (array[mid] < target) {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}