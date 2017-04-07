package Problem201_300;

/**
 * Created by mwindson on 2017/4/7.
 * https://leetcode.com/problems/h-index-ii/#/description
 */
public class Problem275 {
    public static void main(String[] args) {
        int[] citations = {0};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int left = 0, len = citations.length, right = len - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= (len - mid)) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }
}
