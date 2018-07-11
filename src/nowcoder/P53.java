package nowcoder;

public class P53 {
    public static void main(String[] args) {
        String s = "12.e1";
        System.out.println(new P53().isNumeric(s.toCharArray()));
    }

    public boolean isNumeric(char[] str) {
        boolean beforeSign = true;
        boolean numBeforePoint = false;
        boolean numAfterPoint = false;
        boolean afterE = false;
        boolean hasPoint = false;
        boolean numAfterE = false;
        for (char c : str) {
            if (c == '+' || c == '-') {
                if (beforeSign) {
                    beforeSign = false;
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (hasPoint || afterE) {
                    return false;
                } else if (numBeforePoint) {
                    hasPoint = true;
                }
            } else if (c >= '0' && c <= '9') {
                if (hasPoint) {
                    numAfterPoint = true;
                    numBeforePoint = false;
                } else if (afterE) {
                    numAfterE = true;
                } else {
                    numBeforePoint = true;
                }
                beforeSign = false;
            } else if (c == 'e' || c == 'E') {
                if (afterE) {
                    return false;
                } else {
                    afterE = true;
                    beforeSign = true;
                    numAfterPoint = false;
                    numBeforePoint = false;
                }
            } else {
                return false;
            }
        }
        return numBeforePoint || numAfterPoint || numAfterE;
    }
}
