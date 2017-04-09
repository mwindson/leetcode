package Problem101_200;

/**
 * Created by mwindson on 2017/4/9.
 * https://leetcode.com/problems/compare-version-numbers/#/description
 */
public class Problem165 {
    public static void main(String[] args) {
        String version1 = "1.0.0.0.0.0.1";
        String version2 = "1.0";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        if (ver1.length > ver2.length)
            return 0 - compareVersion(version2, version1);
        int res = 0;
        int i = 0;
        while (i < ver1.length) {
            if (Integer.valueOf(ver1[i]) < Integer.valueOf(ver2[i])) {
                res = -1;
                break;
            } else if (Integer.valueOf(ver1[i]) > Integer.valueOf(ver2[i])) {
                res = 1;
                break;
            }
            i++;
        }
        if (res == 0) {
            while (i < ver2.length) {
                if (Integer.valueOf(ver2[i]) != 0) {
                    res = -1;
                    break;
                }
                i++;
            }
        }
        return res;
    }
}
