package Problem001_100;

/**
 * Created by mwindson on 2017/2/6.
 * https://leetcode.com/problems/implement-strstr/
 */
public class Problem028 {
    public static void main(String[] args) {
        String haystack = "1322";
        String needle = "22";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
