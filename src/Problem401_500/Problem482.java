package Problem401_500;

/**
 * Created by mwindson on 2017/4/1.
 * https://leetcode.com/problems/license-key-formatting/#/description
 */
public class Problem482 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("---", 2));
    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(S.charAt(i));
                count++;
                if (count % K == 0)
                    sb.append('-');
            }
        }
        sb.reverse();
        if(sb.length()==0) return sb.toString();
        return sb.charAt(0) == '-' ? sb.substring(1).toUpperCase() : sb.toString().toUpperCase();
    }
}
