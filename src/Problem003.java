import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by Administrator on 2016/11/21.
 */
public class Problem003 {
    //   超时
//   public static int lengthOfLongestSubstring(String s) {
//        int length = 0;
//        Set<Character> characters = new HashSet<>();
//        String subString = null;
//        boolean isLongest = false;
//        int i = 0;
//
//        for (i = s.length(); i > 0; i--) {
//            for (int j = 0; j + i <= s.length(); j++) {
//                subString = s.substring(j, j + i);
//                for(int m=0;m<subString.length();m++) {
//                    characters.add(subString.charAt(m));
//                }
//                if (characters.size() == subString.length()) {
//                    return i;
//                }else{
//                    characters.clear();
//                }
//            }
//        }
//        return i;
//    }
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int i = 0;
        String subString = "";
        Set<Character> c = new HashSet<>();
        int maxlength = 0;
        int index = 0;

        for (i = 0; i < s.length(); i++) {
            index = subString.indexOf(s.charAt(i));
            if (index >= 0) {
                subString = subString.substring(index + 1) + s.substring(i, i + 1);
            } else {
                subString = subString + s.substring(i, i + 1);
            }
            if (maxlength < subString.length()) {
                maxlength = subString.length();
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        String text = null; // abcabcbb   bbbbbb pwwkew
        Scanner in = new Scanner(System.in);
        text = in.next();
        System.out.print(lengthOfLongestSubstring(text));
    }
}
