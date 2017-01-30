package Problem401_500;

/**
 * Created by mwindson on 2017/1/30.
 * Question：https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class Problem405 {
    public static void main(String[] args) {
        int num = -1234;
        System.out.println(toHex(num));
    }

    static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}
