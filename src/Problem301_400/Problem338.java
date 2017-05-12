package Problem301_400;


/**
 * Created by mwindson on 2017/5/12.
 * https://leetcode.com/problems/counting-bits/#/description
 */
public class Problem338 {
    public static void main(String[] args) {
        System.out.println(countBits(16));
    }

    public static int[] countBits(int num) {
        int[] bitCount = new int[num + 1];
        bitCount[0] = 0;
        int index = 0;
        int count = 1;
        while (index < num) {
            for (int i = 0; i < count && i + index < num; i++) {
                bitCount[i + count] = bitCount[i] + 1;
            }
            index += count;
            count *= 2;
        }
        return bitCount;
    }
}
