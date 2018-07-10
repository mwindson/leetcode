package nowcoder;

import java.util.*;

public class P63 {
    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        list.add(left, num);
    }

    public Double GetMedian() {
        int size = list.size();
        double ret;
        if (size % 2 != 0) {
            ret = (double) (list.get(size / 2));
        } else {
            ret = (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        }
        return ret;
    }

    public static void main(String[] args) {
        P63 p = new P63();
        int[] nums = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int num : nums) {
            p.Insert(num);
            System.out.println(p.GetMedian());
        }
    }
}
