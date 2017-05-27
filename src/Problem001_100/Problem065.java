package Problem001_100;

import java.util.regex.Pattern;

/**
 * Created by mwindson on 2017/5/27.
 * https://leetcode.com/problems/valid-number/#/solutions
 */
// meaningless problem: many edge casea and
public class Problem065 {
    public static void main(String[] args) {
        System.out.println(isNumber("e-0"));
    }

    // [-+]?(
    // ([0-9]+(.[0-9]*)?)|.[0-9]+)
    // (e[-+]?[0-9]+)?
    public static boolean isNumber(String s) {
        s = s.trim();

        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNum = false;
        boolean numberAferE = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasNum = true;
                numberAferE = true;
            } else if (s.charAt(i) == '.') {
                if (hasE || hasPoint) return false;
                hasPoint = true;
            } else if (s.charAt(i) == 'e') {
                if (hasE || !hasNum) return false;
                numberAferE = false;
                hasE = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        return hasNum && numberAferE;
    }
}
