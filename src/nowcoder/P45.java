package nowcoder;

import java.util.Arrays;

public class P45 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        int i = 0;
        int zeroCount = 0;
        while (i < numbers.length && numbers[i] == 0) {
            zeroCount++;
            i++;
        }
        i++;
        while (i < numbers.length) {
            int diff = numbers[i] - numbers[i - 1];
            if (diff == 1) {
                i++;
            } else if (diff > 1) {
                if (zeroCount < diff - 1) return false;
                zeroCount -= diff - 1;
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
