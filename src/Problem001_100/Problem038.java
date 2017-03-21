package Problem001_100;

/**
 * Created by mwindson on 2017/3/21.
 * https://leetcode.com/problems/count-and-say/#/description
 */
public class Problem038 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    // 本题题意是根据第i-1项的数字分布写出i项数字的读法，一次类推，第0项为“1”
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1, count = 1; j <= s.length(); j++) {
                if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
                    sb.append(count);
                    sb.append(s.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
