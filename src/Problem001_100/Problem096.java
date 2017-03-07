package Problem001_100;

/**
 * Created by mwindson on 2017/3/7.
 * https://leetcode.com/problems/unique-binary-search-trees/?tab=Description
 */
public class Problem096 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
