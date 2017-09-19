package Problem600_700;

/**
 * Created by mwindson on 2017/9/19.
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */
public class Problem680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abacb"));
        System.out.println(validPalindrome("abacab"));
    }

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        if (i >= j) return true;

        if (isPal(s, i + 1, j) || isPal(s, i, j - 1)) return true;
        return false;
    }

    private static boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }
}
