package Problem001_100;

/**
 * Created by mwindson on 2017/2/1.
 * Question: https://leetcode.com/problems/longest-common-prefix/
 */
public class Problem014 {
    public static void main(String[] args) {
        String[] str = {"aabcaab", "aabcde", "aabce", "aabcde"};
        System.out.println(longestCommonPrefix(str));
    }

//    public static String longestCommonPrefix(String[] strs) {
//        int count = strs.length;
//        if (count == 0) return "";
//        while (count > 1) {
//            for (int i = 0; i < count / 2; i++) {
//                strs[i] = findCommonPrefix(strs[i], strs[count - 1 - i]);
//            }
//            if (count % 2 == 0) {
//                count /= 2;
//            } else {
//                count = (count + 1) / 2;
//            }
//        }
//        return strs[0];
//    }
//
//    private static String findCommonPrefix(String s1, String s2) {
//        String commonPrefix = "";
//        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
//            if (s1.charAt(i) == s2.charAt(i)) {
//                commonPrefix += s1.charAt(i);
//            } else {
//                break;
//            }
//        }
//        return commonPrefix;
//    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            // indexof 返回找到字符第一个位置
            while (strs[i].indexOf(pre) != 0)
                // 每次减少一个字符
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}
