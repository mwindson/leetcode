package nowcoder;

public class P13 {
    public void reOrderArray(int[] array) {
        int oddCount = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }
        int i = 0, j = oddCount;
        int[] copy = array.clone();
        for (int num : copy) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }
}
