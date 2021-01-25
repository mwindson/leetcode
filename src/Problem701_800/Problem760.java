package Problem701_800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2018/1/22.
 * https://leetcode.com/problems/find-anagram-mappings/description/
 */
public class Problem760 {
    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        System.out.println(Arrays.toString(anagramMappings(A, B)));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(B[i], i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(A[i]);
        }
        return result;
    }
}
