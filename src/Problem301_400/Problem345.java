package Problem301_400;

/**
 * Created by mwindson on 2017/5/15.
 * https://leetcode.com/problems/reverse-vowels-of-a-string/#/description
 */
public class Problem345 {
    public static void main(String[] args) {
        String s = "hll";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            while (!isVowels(charArray[left])) {
                if (left < s.length() - 1)
                    left++;
                else
                    break;
            }
            while (!isVowels(charArray[right])) {
                if (right > 0)
                    right--;
                else
                    break;
            }
            if (left >= right) break;
            char tmp = charArray[right];
            charArray[right] = charArray[left];
            charArray[left] = tmp;
            left++;
            right--;
        }
        return String.valueOf(charArray);
    }

    private static boolean isVowels(char c) {
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            return false;
        }
        return true;
    }
}
