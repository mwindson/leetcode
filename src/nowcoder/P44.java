package nowcoder;

public class P44 {
    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        Integer prev = null;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                if (prev != null) {
                    StringBuilder tmp = new StringBuilder(sb.substring(prev, i)).reverse();
                    sb.replace(prev, i, tmp.toString());
                    prev = null;
                }
            } else {
                if (prev == null) {
                    prev = i;
                }
                if (i == sb.length() - 1) {
                    StringBuilder tmp = new StringBuilder(sb.substring(prev)).reverse();
                    sb.replace(prev, i + 1, tmp.toString());
                }
            }
        }
        return sb.toString();
    }
}
