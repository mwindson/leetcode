package nowcoder;

import java.util.ArrayList;

public class P64 {
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(new P64().maxInWindows(num, size));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        if (size == 0 || size > num.length) return ret;
        for (int i = 0; i < size; i++) {
            while (list.size() != 0 && num[i] > num[list.get(list.size() - 1)]) {
                list.remove(list.size() - 1);
            }
            list.add(i);
        }
        ret.add(num[list.get(0)]);
        for (int i = size; i < num.length; i++) {
            if (list.get(0) == i - size) {
                list.remove(0);
            }
            while (list.size() != 0 && num[i] > num[list.get(list.size() - 1)]) {
                list.remove(list.size() - 1);
            }
            list.add(i);
            ret.add(num[list.get(0)]);
        }
        return ret;
    }
}
