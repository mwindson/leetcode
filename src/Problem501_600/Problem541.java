package Problem501_600;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/reverse-string-ii/#/description
 */
public class Problem541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 3;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        boolean needReverse = true;
        int i = 0;
        for (i = 0; i + k < s.length(); i += k) {
            if (needReverse)
                sb.append(new StringBuilder(s.substring(i, i + k)).reverse());
            else
                sb.append(s.substring(i, i + k));
            needReverse = !needReverse;
        }
        if (i < s.length()) {
            if (!needReverse)
                sb.append(s.substring(i));
            else
                sb.append(new StringBuilder(s.substring(i)).reverse());
        }
        return sb.toString();
    }
}
