package Problem401_500;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/3/23.
 * https://leetcode.com/problems/heaters/#/solutions
 */
public class Problem475 {
    public static void main(String[] args) {
        int[] houses = {1, 5};
        int[] heaters = {10};
        System.out.println(findRadius(houses, heaters));
    }

    // Based on 2 pointers, the idea is to find the nearest heater for each house, by comparing the next heater with the current heater.
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0;
        int res = 0;
        for (int house : houses) {
            // the house is in the range of heaters
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2)
                i++;
            res = Math.max(res, Math.abs(house - heaters[i]));
        }
        return res;
    }
}
