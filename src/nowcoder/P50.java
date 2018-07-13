package nowcoder;

public class P50 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0 || numbers == null) return false;
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            count[numbers[i]]++;
        }
        for (int i = 0; i < length; i++) {
            if (count[i] >= 2) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }
}
