package Problem201_300;

/**
 * Created by mwindson on 2017/4/7.
 * https://leetcode.com/problems/first-bad-version/#/description
 */
public class Problem278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    private static boolean isBadVersion(int version) {
        return version >= 2;
    }
}
