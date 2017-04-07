package Problem201_300;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/4/7.
 * https://leetcode.com/problems/h-index/#/description
 */
public class Problem274 {
    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        while (hIndex < citations.length) {
            if (citations[hIndex] >= citations.length - hIndex) {
                break;
            }
            hIndex++;
        }
        return citations.length - hIndex;
    }
}
