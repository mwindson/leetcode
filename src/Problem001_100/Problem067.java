package Problem001_100;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/add-binary/#/description
 */
public class Problem067 {
    public static void main(String[] args) {
        String a = "11";
        String b = "110";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder A = new StringBuilder(a);
        StringBuilder B = new StringBuilder(b);
        StringBuilder result = new StringBuilder();
        A.reverse();
        B.reverse();
        int carryBit = 0;
        int len = Math.max(A.length(), B.length());
        for (int i = 0; i < len; i++) {
            int sum = (i >= A.length() ? 0 : A.charAt(i) - '0') + (i >= B.length() ? 0 : B.charAt(i) - '0') + carryBit;
            if (sum >= 2) {
                carryBit = 1;
                sum -= 2;
            } else {
                carryBit = 0;
            }
            result.append(sum);
        }
        if (carryBit == 1)
            result.append(1);
        return result.reverse().toString();
    }
}
