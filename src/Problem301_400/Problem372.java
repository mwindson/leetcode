package Problem301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/5/16.
 * https://leetcode.com/problems/super-pow/#/description
 */
public class Problem372 {
    public static void main(String[] args) {
        int a = 2;
        int[] b = {1, 1, 0};
        System.out.println(superPow(a, b));
    }

    //  余数会在一定数量后循环
    static int DIV = 1337;

    static List<Integer> findLoop(int a) {
        List<Integer> index = new ArrayList<>();
        boolean[] set = new boolean[DIV];
        int rem = a % DIV;
        while (!set[rem]) {
            set[rem] = true;
            index.add(rem);
            rem = (rem * a) % DIV;
        }
        return index;
    }

    static int modBy(int[] b, int m) {
        int rem = 0;
        for (int i = 0; i < b.length; i++) {
            rem = (rem * 10 + b[i]) % m;
        }
        return rem;
    }

    public static int superPow(int a, int[] b) {
        if (a == 0 || a == DIV || b == null || b.length == 0) return 0;
        if (a == 1) return 1;
        if (a > DIV) return superPow(a % DIV, b);
        List<Integer> index = findLoop(a);
        int loopSize = index.size();
        int rem = modBy(b, loopSize);
        rem = rem == 0 ? loopSize : rem;
        return index.get(rem - 1);
    }
}
