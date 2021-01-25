package Problem401_500;

/**
 * Created by mwindson on 2017/1/30.
 * Question：https://leetcode.com/submissions/detail/91047750/
 */
public class Problem415 {
    public static void main(String[] args) {
        String num1 = "0", num2 = "0";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        // i<0 && j<0 && carry==0 时才停止
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

}
