package Problem401_500;

/**
 * Created by mwindson on 2017/3/20.
 * https://leetcode.com/problems/number-of-segments-in-a-string/#/description
 */
public class Problem434 {
    public static void main(String[] args) {
        String s = "    foo    bar";
        System.out.println(countSegments(s));
    }

    public static int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
//        String[] segments = s.split("\\s+");
        return s.split("\\s+").length;
    }
}
