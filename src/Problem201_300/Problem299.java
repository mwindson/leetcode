package Problem201_300;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/4/10.
 * https://leetcode.com/problems/bulls-and-cows/#/description
 */
public class Problem299 {
    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        String res = "";
        // 位置正确且值正确的数
        int bulls = 0;
        // 值正确但位置不对的数
        int cows = 0;
        // 每个数的出现次数
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                // 值不等则s的次+1数，g的次数-1；
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
