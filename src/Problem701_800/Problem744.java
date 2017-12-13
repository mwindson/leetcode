package Problem701_800;

/**
 * Created by mwindson on 2017/12/12.
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class Problem744 {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'j';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (letters[middle] > target) {
                right = middle - 1;
            } else if (letters[middle] <= target) {
                left = middle + 1;
            }
        }
        if (left >= letters.length) left = 0;
        return letters[left];
    }
}
