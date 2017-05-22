package Problem401_500;

import java.util.Objects;

/**
 * Created by mwindson on 2017/5/22.
 * https://leetcode.com/problems/validate-ip-address/#/description
 */
public class Problem468 {
    public static void main(String[] args) {
        String IP = "00.0.0.0";
        System.out.println(validIPAddress(IP));
    }

    public static String validIPAddress(String IP) {
        // 共4部分，0-255且无前导0
        if (IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))
            return "IPv4";
        // 共8部分,每个部分不超过4次
        if (IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})")) return "IPv6";
        return "Neither";
    }
}
