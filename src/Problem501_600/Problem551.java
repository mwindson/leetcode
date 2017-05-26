package Problem501_600;

/**
 * Created by mwindson on 2017/5/26.
 * https://leetcode.com/problems/student-attendance-record-i/#/description
 */
public class Problem551 {
    public static void main(String[] args) {
        System.out.println(checkRecord("LLLAL"));
    }

    public static boolean checkRecord(String s) {
        int[] counts = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                counts[0]++;
            } else if (s.charAt(i) == 'L') {
                if (i > 1 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                    counts[1]++;
                }
            }
            if (counts[0] > 1 || counts[1] > 0)
                return false;
        }
        return true;
    }
}
