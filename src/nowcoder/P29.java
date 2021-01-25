package nowcoder;

public class P29 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sum = sum >= 0 ? sum + array[i] : array[i];
            } else {
                sum = sum > 0 ? sum + array[i] : array[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}