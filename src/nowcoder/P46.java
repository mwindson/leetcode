package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class P46 {
    public static void main(String[] args) {
        int[] ns = {0, 5};
        int[] ms = {0, 3};
        P46 p = new P46();
        for (int i = 0; i < ns.length; i++) {
            System.out.println(p.LastRemaining_Solution(ns[i], ms[i]));
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) return -1;
        List<Integer> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(i);
        int start = 0;
        while (children.size() > 1) {
            int next = (start + m - 1) % children.size();
            children.remove(next);
            start = next < children.size() ? next : 0;
        }
        return children.get(0);
    }
}
