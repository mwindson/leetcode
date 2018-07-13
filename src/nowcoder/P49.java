package nowcoder;

public class P49 {
    public int StrToInt(String str) {
        long res = 0;
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int digit = c - '0';
                res = res * 10 + digit;
            } else if (c == ' ') {
                continue;
            } else if (c == '+') {
                if (flag != 0) {
                    return 0;
                } else {
                    flag = 1;
                }
            } else if (c == '-') {
                if (flag != 0) {
                    return 0;
                } else {
                    flag = -1;
                }
            } else {
                return 0;
            }
        }
        res = res * (flag >= 0 ? 1 : -1);
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
