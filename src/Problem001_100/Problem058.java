package Problem001_100;

/**
 * Created by mwindson on 2017/2/8.
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Problem058 {
    public static void main(String[] args) {
        String s = "    ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int lastWordStartIndex = -1;
        int lastWordEndIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (lastWordStartIndex == -1 || (i > 0 && s.charAt(i - 1) == ' ')) {
                    lastWordStartIndex = i;
                }
                if (i == s.length() - 1) {
                    lastWordEndIndex = i;
                }
            } else {
                if (i > 0 && s.charAt(i - 1) != ' ') {
                    lastWordEndIndex = i - 1;
                }
            }
        }
        return lastWordStartIndex != -1 && lastWordEndIndex != -1 ? lastWordEndIndex - lastWordStartIndex + 1 : 0;

//     Best
//      return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
