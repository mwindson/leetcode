package Problem600_700;

/**
 * Created by mwindson on 2017/8/21.
 * https://leetcode.com/problems/judge-route-circle/description/
 */
public class Problem657 {
    public static void main(String[] args) {
        String moves = "LR";
        System.out.println(judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        if (moves.length() == 0) return false;
        int count1 = 0, count2 = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                count1++;
            } else if (c == 'R') {
                count1--;
            } else if (c == 'U') {
                count2++;
            } else if (c == 'D') {
                count2--;
            }
        }
        return count1 == 0 && count2 == 0;
    }
}
