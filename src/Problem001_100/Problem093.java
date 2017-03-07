package Problem001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/6.
 * https://leetcode.com/problems/restore-ip-addresses/?tab=Description
 */
public class Problem093 {
    public static void main(String[] args) {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ipAddressesList = new ArrayList<>();
        backTrack(s, "", ipAddressesList, 4, 0);
        return ipAddressesList;
    }

    private static void backTrack(String s, String ip, List<String> list, int count, int start) {
        if (count == 0 && start == s.length()) {
            list.add(ip.substring(1, ip.length()));
        } else {
            for (int i = start; i < s.length() && i < start + 3; i++) {
                if (i + 1 - start != 1 && s.substring(start, i + 1).charAt(0) == '0') {
                    break;
                }
                if (s.length() - i - 1 <= 3 * count && Integer.valueOf(s.substring(start, i + 1)) <= 255) {
                    ip = ip + '.' + s.substring(start, i + 1);
                    backTrack(s, ip, list, count - 1, i + 1);
                    ip = ip.substring(0, ip.length() - i + start - 2);
                }
            }
        }
    }
}
