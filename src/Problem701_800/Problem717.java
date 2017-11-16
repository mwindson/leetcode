package Problem701_800;

/**
 * Created by mwindson on 2017/11/16.
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 */
public class Problem717 {
    public static void main(String[] args) {
        int[] bits = {0, 0, 1, 0, 1, 1, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}
