package nowcoder;

public class P43 {
    public String LeftRotateString(String str, int n) {
        if (n >= str.length()) return str;
        String left = str.substring(0, n);
        String right = str.substring(n);
        return right + left;
    }
}
