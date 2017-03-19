package Problem501_600;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/detect-capital/#/description
 */
public class Problem520 {
    public static void main(String[] args) {
        String word = "ffffG";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 0) return false;
        int upperCaseCount = 0, lowerCaseCount = 0;
        boolean hasCapitalUse = true;
        boolean firstIsCaptial = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                lowerCaseCount++;
            else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                upperCaseCount++;
                if (i == 0) firstIsCaptial = true;
            }
            if (upperCaseCount > 1 && lowerCaseCount != 0) {
                hasCapitalUse = false;
                break;
            }
        }
        if (upperCaseCount == 1 && !firstIsCaptial) hasCapitalUse = false;
        return hasCapitalUse;
    }
}
